package co.com.megacode.util;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.StringTokenizer;

@Component
public class AmazonS3ClientImage {

    private String awsS3AudioBucket;
    private AmazonS3 amazonS3;

    @Autowired
    public AmazonS3ClientImage(Region awsRegion, AWSCredentialsProvider awsCredentialsProvider, String awsS3AudioBucket)
    {
        this.amazonS3 = AmazonS3ClientBuilder.standard()
                .withCredentials(awsCredentialsProvider)
                .withRegion(awsRegion.getName()).build();
        this.awsS3AudioBucket = awsS3AudioBucket;
    }

    @Async
    public String saveImageS3Bucket(MultipartFile multipartFile, boolean enablePublicReadAccess, String path) throws IOException, NoSuchAlgorithmException {
        String fileName = multipartFile.getOriginalFilename();
        String fileNameMD5 = null;

        try {
            StringTokenizer st = new StringTokenizer(fileName, ".");
            fileNameMD5 = HashEncrypter.hashMD5(st.nextToken());
        } catch (NoSuchAlgorithmException e) {
            throw e;
        }

        StringBuilder sb = new StringBuilder(path);
        sb.append(fileNameMD5);
        sb.append("-");
        sb.append(fileName);
        String fullName = sb.toString();

        File file = new File(fileName);

        try {

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(multipartFile.getBytes());
            fos.close();

            PutObjectRequest putObjectRequest = new PutObjectRequest(this.awsS3AudioBucket, fullName, file);

            if (enablePublicReadAccess) {
                putObjectRequest.withCannedAcl(CannedAccessControlList.PublicRead);
            }
            this.amazonS3.putObject(putObjectRequest);


        } catch (IOException | AmazonServiceException ex) {
            file.delete();
            throw ex;
        }
        file.delete();
        return fullName;
    }

    @Async
    public void deleteFileFromS3Bucket(String fileName)
    {
        try {
            amazonS3.deleteObject(new DeleteObjectRequest(awsS3AudioBucket, fileName));
        } catch (AmazonServiceException ex) {
            throw ex;
        }
    }
}

package co.com.megacode.enumeration;

import co.com.megacode.constant.PathsImages;

public enum TypeImageEnum {

    PRINCIPAL_PAGE_TYPE(1,"principal-page", PathsImages.IMAGE_GENERAL_PATH),
    USER_PROFILE_TYPE(2,"user-profile", PathsImages.IMAGE_USER_PROFILE_PATH);

    private long id;

    private String nameType;

    private String path;

    TypeImageEnum(long id, String nameType, String path) {
        this.id = id;
        this.nameType = nameType;
        this.path = path;
    }

    public long getId() {
        return id;
    }

    public String getNameType() {
        return nameType;
    }

    public String getPath() {
        return path;
    }

}

package cn.seifly.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;

/**
 * 读取项目相关配置
 * 
 * @author 
 */
@Component
@ConfigurationProperties("javapress")
public class JavaPressConfig
{
    /** 项目名称 */
    private static String name;

    /** 版本 */
    private static String version;

    /** 版权年份 */
    private static String copyrightYear;

    /** 上传路径 */
    private static String profile;

    /** 获取地址开关 */
    private static boolean addressEnabled;

    /** 验证码类型 */
    private static String captchaType;

    /**
     * 描述
     */
    @NotEmpty(message = "描述不能为空")
    private static String description;
    /**
     * 作者
     */
    @NotEmpty(message = "作者不能为空")
    private static String author;

    /**
     * url
     */
    @NotEmpty(message = "扫描的 package 不能为空")
    private static String url;
    /**
     * email
     */
    @NotEmpty(message = "扫描的 email 不能为空")
    private static String email;

    /**
     * license
     */
    @NotEmpty(message = "扫描的 license 不能为空")
    private static String license;

    /**
     * license-url
     */
    @NotEmpty(message = "扫描的 license-url 不能为空")
    private static String licenseUrl;

    public static String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public static String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    public String getCopyrightYear()
    {
        return copyrightYear;
    }

    public void setCopyrightYear(String copyrightYear)
    {
        this.copyrightYear = copyrightYear;
    }

    public static String getProfile()
    {
        return profile;
    }

    public void setProfile(String profile)
    {
        JavaPressConfig.profile = profile;
    }

    public static boolean isAddressEnabled()
    {
        return addressEnabled;
    }

    public void setAddressEnabled(boolean addressEnabled)
    {
        JavaPressConfig.addressEnabled = addressEnabled;
    }

    public static String getCaptchaType() {
        return captchaType;
    }

    public void setCaptchaType(String captchaType) {
        JavaPressConfig.captchaType = captchaType;
    }

    /**
     * 获取导入上传路径
     */
    public static String getImportPath()
    {
        return getProfile() + "/import";
    }

    /**
     * 获取头像上传路径
     */
    public static String getAvatarPath()
    {
        return getProfile() + "/avatar";
    }

    /**
     * 获取下载路径
     */
    public static String getDownloadPath()
    {
        return getProfile() + "/download/";
    }

    /**
     * 获取上传路径
     */
    public static String getUploadPath()
    {
        return getProfile() + "/upload";
    }

    /**
     * 获取文件上传路径
     */
    public static String getFilePath()
    {
        return getProfile() + "/file";
    }

    public static String getDescription() {
        return description;
    }

    public  void setDescription(String description) {
        JavaPressConfig.description = description;
    }

    public static String getAuthor() {
        return author;
    }

    public  void setAuthor(String author) {
        JavaPressConfig.author = author;
    }

    public static String getUrl() {
        return url;
    }

    public  void setUrl(String url) {
        JavaPressConfig.url = url;
    }

    public static String getEmail() {
        return email;
    }

    public  void setEmail(String email) {
        JavaPressConfig.email = email;
    }

    public static String getLicense() {
        return license;
    }

    public  void setLicense(String license) {
        JavaPressConfig.license = license;
    }

    public static String getLicenseUrl() {
        return licenseUrl;
    }

    public  void setLicenseUrl(String licenseUrl) {
        JavaPressConfig.licenseUrl = licenseUrl;
    }

}

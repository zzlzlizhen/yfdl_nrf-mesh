package com.phyplusinc.android.phymeshprovisioner.entity;

public class User {
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 盐
     */
    private String salt;
    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 状态  0：禁用   1：正常
     */
    private int status;
    /**
     * 用户类型 2使用者  1  管理者
     * */
    private Long roleId;
    private Long parentId;//父ids
    private String allParentId;//父类ids
    private Integer deviceCount; //设备数量
    private Integer projectCount;//项目数量
    private String headUrl;//头像
    private Long updateUser;

    private String realName;//真实姓名

    /**
     * 有效期 0：半年  1： 一年 2：俩年  3：三年  4：永久
     * */
    private Integer termOfValidity;

    /**
     * 邮箱绑定状态 0未绑定 1已绑定
     * */
    private Integer type;

    /**
     * 是否删除
     * */
    private Integer flag;
    /**
     * 手机号绑定状态 0未绑定 1已绑定
     * */
    private Integer isBindMtype;
    /**
     * 当前用户id
     * */
    private Long curUid;
    /**
     * 当前用户所有父id
     * */
    private String curAllParentId;
    /**
     *是否是厂家0否 1是
     */
    private int operation;
    /**
     * 是否升级 0否 1升级
     */
    private Integer upgrade;
    /**
     * 是否显示城市相关信息 0 否，1是
     */
    private Integer showCity;
    /**
     * 公司名称
     */
    private String companyName;
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getAllParentId() {
        return allParentId;
    }

    public void setAllParentId(String allParentId) {
        this.allParentId = allParentId;
    }

    public Integer getDeviceCount() {
        return deviceCount;
    }

    public void setDeviceCount(Integer deviceCount) {
        this.deviceCount = deviceCount;
    }

    public Integer getProjectCount() {
        return projectCount;
    }

    public void setProjectCount(Integer projectCount) {
        this.projectCount = projectCount;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getTermOfValidity() {
        return termOfValidity;
    }

    public void setTermOfValidity(Integer termOfValidity) {
        this.termOfValidity = termOfValidity;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getIsBindMtype() {
        return isBindMtype;
    }

    public void setIsBindMtype(Integer isBindMtype) {
        this.isBindMtype = isBindMtype;
    }

    public Long getCurUid() {
        return curUid;
    }

    public void setCurUid(Long curUid) {
        this.curUid = curUid;
    }

    public String getCurAllParentId() {
        return curAllParentId;
    }

    public void setCurAllParentId(String curAllParentId) {
        this.curAllParentId = curAllParentId;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public Integer getUpgrade() {
        return upgrade;
    }

    public void setUpgrade(Integer upgrade) {
        this.upgrade = upgrade;
    }

    public Integer getShowCity() {
        return showCity;
    }

    public void setShowCity(Integer showCity) {
        this.showCity = showCity;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}

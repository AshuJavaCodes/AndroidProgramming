package com.example.retrofitmasterpractice2.ResponseModels;

import java.util.ArrayList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
public class LoginResponseModel {
    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("isParent")
    @Expose
    private boolean isParent;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Data")
    @Expose
        private ArrayList<LoginData> Data = null;
    @SerializedName("Token")
    @Expose
    private String token;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isIsParent() {
        return isParent;
    }

    public void setIsParent(boolean isParent) {
        this.isParent = isParent;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<LoginData> getData() {
        return Data;
    }

    public void setData(ArrayList<LoginData> Data) {
        this.Data = Data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    //Array_JSON_START0
    public class LoginData {

        @SerializedName("ParentId")
        @Expose
        private int parentId;
        @SerializedName("ParentName")
        @Expose
        private String parentName;
        @SerializedName("ParentMobile")
        @Expose
        private long parentMobile;
        @SerializedName("ParentPassword")
        @Expose
        private String parentPassword;
        @SerializedName("ParentEmail")
        @Expose
        private Object parentEmail;
        @SerializedName("ParentAddress")
        @Expose
        private String parentAddress;
        @SerializedName("FBToken")
        @Expose
        private String fBToken;
        @SerializedName("StatusId")
        @Expose
        private int statusId;
        @SerializedName("SchoolId")
        @Expose
        private int schoolId;
        @SerializedName("ExpireDate")
        @Expose
        private Object expireDate;
        @SerializedName("CreatedById")
        @Expose
        private int createdById;
        @SerializedName("ModifiedById")
        @Expose
        private int modifiedById;
        @SerializedName("CreationDate")
        @Expose
        private String creationDate;
        @SerializedName("ModificationDate")
        @Expose
        private String modificationDate;

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public String getParentName() {
            return parentName;
        }

        public void setParentName(String parentName) {
            this.parentName = parentName;
        }

        public long getParentMobile() {
            return parentMobile;
        }

        public void setParentMobile(long parentMobile) {
            this.parentMobile = parentMobile;
        }

        public String getParentPassword() {
            return parentPassword;
        }

        public void setParentPassword(String parentPassword) {
            this.parentPassword = parentPassword;
        }

        public Object getParentEmail() {
            return parentEmail;
        }

        public void setParentEmail(Object parentEmail) {
            this.parentEmail = parentEmail;
        }

        public String getParentAddress() {
            return parentAddress;
        }

        public void setParentAddress(String parentAddress) {
            this.parentAddress = parentAddress;
        }

        public String getFBToken() {
            return fBToken;
        }

        public void setFBToken(String fBToken) {
            this.fBToken = fBToken;
        }

        public int getStatusId() {
            return statusId;
        }

        public void setStatusId(int statusId) {
            this.statusId = statusId;
        }

        public int getSchoolId() {
            return schoolId;
        }

        public void setSchoolId(int schoolId) {
            this.schoolId = schoolId;
        }

        public Object getExpireDate() {
            return expireDate;
        }

        public void setExpireDate(Object expireDate) {
            this.expireDate = expireDate;
        }

        public int getCreatedById() {
            return createdById;
        }

        public void setCreatedById(int createdById) {
            this.createdById = createdById;
        }

        public int getModifiedById() {
            return modifiedById;
        }

        public void setModifiedById(int modifiedById) {
            this.modifiedById = modifiedById;
        }

        public String getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(String creationDate) {
            this.creationDate = creationDate;
        }

        public String getModificationDate() {
            return modificationDate;
        }

        public void setModificationDate(String modificationDate) {
            this.modificationDate = modificationDate;
        }

    }

}

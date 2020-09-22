package com.my.library.test;

public class VersionBack {

    /**
     * msg : 更新版本号失败
     * flag : -1
     * data : {"code":null,"apk_version":""}
     */
    private String msg;
    private int flag;
    private DataEntity data;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public int getFlag() {
        return flag;
    }

    public DataEntity getData() {
        return data;
    }

    public class DataEntity {
        /**
         * code : null
         * apk_version :
         */
        private String code;
        private String apk_version;

        public void setCode(String code) {
            this.code = code;
        }

        public void setApk_version(String apk_version) {
            this.apk_version = apk_version;
        }

        public String getCode() {
            return code;
        }

        public String getApk_version() {
            return apk_version;
        }
    }
}

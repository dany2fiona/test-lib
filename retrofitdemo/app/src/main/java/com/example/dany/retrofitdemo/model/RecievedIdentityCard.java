package com.example.dany.retrofitdemo.model;

/**
 * Created by dan.y on 2016/8/25.
 */
public class RecievedIdentityCard {
    private int showapi_res_code;
    private String showapi_res_error;
    private ShowApiResBody showapi_res_body;

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public ShowApiResBody getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowApiResBody showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }


    public static class ShowApiResBody {
        private int errNum;
        private IdentityCard retData;
        private String retMsg;
        private int ret_code;

        public int getErrNum() {
            return errNum;
        }

        public void setErrNum(int errNum) {
            this.errNum = errNum;
        }

        public IdentityCard getRetData() {
            return retData;
        }

        public void setRetData(IdentityCard retData) {
            this.retData = retData;
        }

        public String getRetMsg() {
            return retMsg;
        }

        public void setRetMsg(String retMsg) {
            this.retMsg = retMsg;
        }

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }


      public  static class IdentityCard {
            private String address;
            private String birthday;
            private String sex;


            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }
        }
    }

}

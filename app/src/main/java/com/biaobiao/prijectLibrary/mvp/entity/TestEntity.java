package com.biaobiao.prijectLibrary.mvp.entity;

import java.util.List;

/**
 * @author: biao
 * @create: 2019/4/10
 * @Describe:
 */
public class TestEntity {

    /**
     * code : 1
     * message : ok
     * data : {"total":5,"detail":[{"id":1000516,"model":"MG 锐腾  2015款 2.0TGI TST豪华版","salesprice":"7.95","city":"武汉","cityid":0,"tagPic":null,"car_pricing":"15.97","regdate":"2015-4","mileage":"3.62","displacement":"国V","url":"http://zuojiachetest.oss-cn-beijing.aliyuncs.com/platformCar/1000516/_2.jpg?x-oss-process=image/resize,h_150"},{"id":1000515,"model":"标致 标致301  2016款 1.6L 自动舒适版","salesprice":"4.25","city":"武汉","cityid":0,"tagPic":null,"car_pricing":"9.77","regdate":"2015-8","mileage":"5.75","displacement":"国IV(国V)","url":"http://zuojiachetest.oss-cn-beijing.aliyuncs.com/platformCar/1000515/_2.jpg?x-oss-process=image/resize,h_150"},{"id":1000507,"model":"长安 长安CS35  2016款 1.6L 自动豪华型 国IV","salesprice":"10","city":"北京","cityid":110100,"tagPic":null,"car_pricing":"9.29","regdate":"2017-2","mileage":"0.00","displacement":"国IV","url":"http://zuojiachetest.oss-cn-beijing.aliyuncs.com/platformCar/1000507/_2.jpg?x-oss-process=image/resize,h_150"},{"id":1000509,"model":"丰田 锐志  2013款 2.5V 尊锐导航版","salesprice":"18.99","city":"东莞","cityid":441900,"tagPic":null,"car_pricing":"27.48","regdate":"2014-3","mileage":"16.69","displacement":"国IV(国V)","url":"http://images.cheegu.com/img/model/16983_CD5414D994F9C62FDC01CAEB59BAF5CF.jpg"},{"id":1000514,"model":"凯迪拉克 凯迪拉克ATS-L  2017款 28T 领先型","salesprice":"43.69","city":"重庆","cityid":500100,"tagPic":null,"car_pricing":"42.88","regdate":"2018-1","mileage":"16.99","displacement":"国IV(国V)","url":"http://zuojiachetest.oss-cn-beijing.aliyuncs.com/platformCar/1000514/_2.jpg?x-oss-process=image/resize,h_150"}]}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * total : 5
         * detail : [{"id":1000516,"model":"MG 锐腾  2015款 2.0TGI TST豪华版","salesprice":"7.95","city":"武汉","cityid":0,"tagPic":null,"car_pricing":"15.97","regdate":"2015-4","mileage":"3.62","displacement":"国V","url":"http://zuojiachetest.oss-cn-beijing.aliyuncs.com/platformCar/1000516/_2.jpg?x-oss-process=image/resize,h_150"},{"id":1000515,"model":"标致 标致301  2016款 1.6L 自动舒适版","salesprice":"4.25","city":"武汉","cityid":0,"tagPic":null,"car_pricing":"9.77","regdate":"2015-8","mileage":"5.75","displacement":"国IV(国V)","url":"http://zuojiachetest.oss-cn-beijing.aliyuncs.com/platformCar/1000515/_2.jpg?x-oss-process=image/resize,h_150"},{"id":1000507,"model":"长安 长安CS35  2016款 1.6L 自动豪华型 国IV","salesprice":"10","city":"北京","cityid":110100,"tagPic":null,"car_pricing":"9.29","regdate":"2017-2","mileage":"0.00","displacement":"国IV","url":"http://zuojiachetest.oss-cn-beijing.aliyuncs.com/platformCar/1000507/_2.jpg?x-oss-process=image/resize,h_150"},{"id":1000509,"model":"丰田 锐志  2013款 2.5V 尊锐导航版","salesprice":"18.99","city":"东莞","cityid":441900,"tagPic":null,"car_pricing":"27.48","regdate":"2014-3","mileage":"16.69","displacement":"国IV(国V)","url":"http://images.cheegu.com/img/model/16983_CD5414D994F9C62FDC01CAEB59BAF5CF.jpg"},{"id":1000514,"model":"凯迪拉克 凯迪拉克ATS-L  2017款 28T 领先型","salesprice":"43.69","city":"重庆","cityid":500100,"tagPic":null,"car_pricing":"42.88","regdate":"2018-1","mileage":"16.99","displacement":"国IV(国V)","url":"http://zuojiachetest.oss-cn-beijing.aliyuncs.com/platformCar/1000514/_2.jpg?x-oss-process=image/resize,h_150"}]
         */

        private int total;
        private List<DetailBean> detail;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<DetailBean> getDetail() {
            return detail;
        }

        public void setDetail(List<DetailBean> detail) {
            this.detail = detail;
        }

        public static class DetailBean {
            /**
             * id : 1000516
             * model : MG 锐腾  2015款 2.0TGI TST豪华版
             * salesprice : 7.95
             * city : 武汉
             * cityid : 0
             * tagPic : null
             * car_pricing : 15.97
             * regdate : 2015-4
             * mileage : 3.62
             * displacement : 国V
             * url : http://zuojiachetest.oss-cn-beijing.aliyuncs.com/platformCar/1000516/_2.jpg?x-oss-process=image/resize,h_150
             */

            private int id;
            private String model;
            private String salesprice;
            private String city;
            private int cityid;
            private Object tagPic;
            private String car_pricing;
            private String regdate;
            private String mileage;
            private String displacement;
            private String url;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getModel() {
                return model;
            }

            public void setModel(String model) {
                this.model = model;
            }

            public String getSalesprice() {
                return salesprice;
            }

            public void setSalesprice(String salesprice) {
                this.salesprice = salesprice;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public int getCityid() {
                return cityid;
            }

            public void setCityid(int cityid) {
                this.cityid = cityid;
            }

            public Object getTagPic() {
                return tagPic;
            }

            public void setTagPic(Object tagPic) {
                this.tagPic = tagPic;
            }

            public String getCar_pricing() {
                return car_pricing;
            }

            public void setCar_pricing(String car_pricing) {
                this.car_pricing = car_pricing;
            }

            public String getRegdate() {
                return regdate;
            }

            public void setRegdate(String regdate) {
                this.regdate = regdate;
            }

            public String getMileage() {
                return mileage;
            }

            public void setMileage(String mileage) {
                this.mileage = mileage;
            }

            public String getDisplacement() {
                return displacement;
            }

            public void setDisplacement(String displacement) {
                this.displacement = displacement;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}

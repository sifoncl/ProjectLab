package org.example.dao.entities.analysis;

import java.time.LocalDateTime;

public class Biochemical {

    private Integer id;

    private Integer userId;

    private Double alt;

    private Double ast;

    private Double creatinin;

    private Double mochevina;

    private Double bilirubinObsh;

    private Double bilirubinPriamoi;

    private Double bilirubinNepriamoi;

    private Double cholesterin;

    private Double glucose;

    private LocalDateTime getMatirial;

    private LocalDateTime addedResult;

    public Biochemical() {
    }

    public Biochemical(Integer id, Integer userId, Double alt, Double ast,
                       Double creatinin, Double mochevina,
                       Double bilirubinObsh, Double bilirubinPriamoi,
                       Double bilirubinNepriamoi, Double cholesterin,
                       Double glucose, LocalDateTime getMatirial,
                       LocalDateTime addedResult) {
        this.id = id;
        this.userId = userId;
        this.alt = alt;
        this.ast = ast;
        this.creatinin = creatinin;
        this.mochevina = mochevina;
        this.bilirubinObsh = bilirubinObsh;
        this.bilirubinPriamoi = bilirubinPriamoi;
        this.bilirubinNepriamoi = bilirubinNepriamoi;
        this.cholesterin = cholesterin;
        this.glucose = glucose;
        this.getMatirial = getMatirial;
        this.addedResult = addedResult;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getAlt() {
        return alt;
    }

    public void setAlt(Double alt) {
        this.alt = alt;
    }

    public Double getAst() {
        return ast;
    }

    public void setAst(Double ast) {
        this.ast = ast;
    }

    public Double getCreatinin() {
        return creatinin;
    }

    public void setCreatinin(Double creatinin) {
        this.creatinin = creatinin;
    }

    public Double getMochevina() {
        return mochevina;
    }

    public void setMochevina(Double mochevina) {
        this.mochevina = mochevina;
    }

    public Double getBilirubinObsh() {
        return bilirubinObsh;
    }

    public void setBilirubinObsh(Double bilirubinObsh) {
        this.bilirubinObsh = bilirubinObsh;
    }

    public Double getBilirubinPriamoi() {
        return bilirubinPriamoi;
    }

    public void setBilirubinPriamoi(Double bilirubinPriamoi) {
        this.bilirubinPriamoi = bilirubinPriamoi;
    }

    public Double getBilirubinNepriamoi() {
        return bilirubinNepriamoi;
    }

    public void setBilirubinNepriamoi(Double bilirubinNepriamoi) {
        this.bilirubinNepriamoi = bilirubinNepriamoi;
    }

    public Double getCholesterin() {
        return cholesterin;
    }

    public void setCholesterin(Double cholesterin) {
        this.cholesterin = cholesterin;
    }

    public Double getGlucose() {
        return glucose;
    }

    public void setGlucose(Double glucose) {
        this.glucose = glucose;
    }

    public LocalDateTime getGetMatirial() {
        return getMatirial;
    }

    public void setGetMatirial(LocalDateTime getMatirial) {
        this.getMatirial = getMatirial;
    }

    public LocalDateTime getAddedResult() {
        return addedResult;
    }

    public void setAddedResult(LocalDateTime addedResult) {
        this.addedResult = addedResult;
    }

    @Override
    public String toString() {
        return "Biochemical{" +
               "id=" + id +
               ", userId=" + userId +
               ", alt=" + alt +
               ", ast=" + ast +
               ", creatinin=" + creatinin +
               ", mochevina=" + mochevina +
               ", bilirubinObsh=" + bilirubinObsh +
               ", bilirubinPriamoi=" + bilirubinPriamoi +
               ", bilirubinNepriamoi=" + bilirubinNepriamoi +
               ", cholesterin=" + cholesterin +
               ", glucose=" + glucose +
               ", getMatirial=" + getMatirial +
               ", addedResult=" + addedResult +
               '}';
    }


    public static final class BiochemicalBuilder {
        private Integer id;
        private Integer userId;
        private Double alt;
        private Double ast;
        private Double creatinin;
        private Double mochevina;
        private Double bilirubinObsh;
        private Double bilirubinPriamoi;
        private Double bilirubinNepriamoi;
        private Double cholesterin;
        private Double glucose;
        private LocalDateTime getMatirial;
        private LocalDateTime addedResult;

        private BiochemicalBuilder() {
        }

        public static BiochemicalBuilder aBiochemical() {
            return new BiochemicalBuilder();
        }

        public BiochemicalBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public BiochemicalBuilder withUserId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public BiochemicalBuilder withAlt(Double alt) {
            this.alt = alt;
            return this;
        }

        public BiochemicalBuilder withAst(Double ast) {
            this.ast = ast;
            return this;
        }

        public BiochemicalBuilder withCreatinin(Double creatinin) {
            this.creatinin = creatinin;
            return this;
        }

        public BiochemicalBuilder withMochevina(Double mochevina) {
            this.mochevina = mochevina;
            return this;
        }

        public BiochemicalBuilder withBilirubinObsh(Double bilirubinObsh) {
            this.bilirubinObsh = bilirubinObsh;
            return this;
        }

        public BiochemicalBuilder withBilirubinPriamoi(Double bilirubinPriamoi) {
            this.bilirubinPriamoi = bilirubinPriamoi;
            return this;
        }

        public BiochemicalBuilder withBilirubinNepriamoi(Double bilirubinNepriamoi) {
            this.bilirubinNepriamoi = bilirubinNepriamoi;
            return this;
        }

        public BiochemicalBuilder withCholesterin(Double cholesterin) {
            this.cholesterin = cholesterin;
            return this;
        }

        public BiochemicalBuilder withGlucose(Double glucose) {
            this.glucose = glucose;
            return this;
        }

        public BiochemicalBuilder withGetMatirial(LocalDateTime getMatirial) {
            this.getMatirial = getMatirial;
            return this;
        }

        public BiochemicalBuilder withAddedResult(LocalDateTime addedResult) {
            this.addedResult = addedResult;
            return this;
        }

        public Biochemical build() {
            Biochemical biochemical = new Biochemical();
            biochemical.setId(id);
            biochemical.setUserId(userId);
            biochemical.setAlt(alt);
            biochemical.setAst(ast);
            biochemical.setCreatinin(creatinin);
            biochemical.setMochevina(mochevina);
            biochemical.setBilirubinObsh(bilirubinObsh);
            biochemical.setBilirubinPriamoi(bilirubinPriamoi);
            biochemical.setBilirubinNepriamoi(bilirubinNepriamoi);
            biochemical.setCholesterin(cholesterin);
            biochemical.setGlucose(glucose);
            biochemical.setGetMatirial(getMatirial);
            biochemical.setAddedResult(addedResult);
            return biochemical;
        }
    }
}

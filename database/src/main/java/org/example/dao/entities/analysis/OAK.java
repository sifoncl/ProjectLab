package org.example.dao.entities.analysis;

import java.time.LocalDateTime;

public class OAK {

    private Integer id;

    private Integer userId;

    private Integer rbc;

    private Integer wbc;

    private Integer trombocitis;

    private Double hb;

    private Double hematocritis;

    private Double cp;

    private Double reticulocitis;

    private Double soe;

    private Double palochkoydernieGranulociti;

    private Double segmentoydernieGranulociti;

    private Double eosinofiles;

    private Double basofiles;

    private Double limfocities;

    private Double monocities;

    private Double metolmielocites;

    private Double mielocities;

    private LocalDateTime getMatirial;

    private LocalDateTime addedResult;

    public OAK() {
    }

    public OAK(Integer id, Integer userId, Integer rbc,
               Integer wbc, Integer trombocitis,
               Double hb, Double hematocritis, Double cp,
               Double reticulocitis,
               Double soe, Double palochkoydernieGranulociti,
               Double segmentoydernieGranulociti, Double eosinofiles,
               Double basofiles, Double limfocities, Double monocities,
               Double metolmielocites, Double mielocities,
               LocalDateTime getMatirial, LocalDateTime addedResult) {
        this.id = id;
        this.userId = userId;
        this.rbc = rbc;
        this.wbc = wbc;
        this.trombocitis = trombocitis;
        this.hb = hb;
        this.hematocritis = hematocritis;
        this.cp = cp;
        this.reticulocitis = reticulocitis;
        this.soe = soe;
        this.palochkoydernieGranulociti = palochkoydernieGranulociti;
        this.segmentoydernieGranulociti = segmentoydernieGranulociti;
        this.eosinofiles = eosinofiles;
        this.basofiles = basofiles;
        this.limfocities = limfocities;
        this.monocities = monocities;
        this.metolmielocites = metolmielocites;
        this.mielocities = mielocities;
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

    public Integer getRbc() {
        return rbc;
    }

    public void setRbc(Integer rbc) {
        this.rbc = rbc;
    }

    public Integer getWbc() {
        return wbc;
    }

    public void setWbc(Integer wbc) {
        this.wbc = wbc;
    }

    public Integer getTrombocitis() {
        return trombocitis;
    }

    public void setTrombocitis(Integer trombocitis) {
        this.trombocitis = trombocitis;
    }

    public Double getHb() {
        return hb;
    }

    public void setHb(Double hb) {
        this.hb = hb;
    }

    public Double getHematocritis() {
        return hematocritis;
    }

    public void setHematocritis(Double hematocritis) {
        this.hematocritis = hematocritis;
    }

    public Double getCp() {
        return cp;
    }

    public void setCp(Double cp) {
        this.cp = cp;
    }

    public Double getReticulocitis() {
        return reticulocitis;
    }

    public void setReticulocitis(Double reticulocitis) {
        this.reticulocitis = reticulocitis;
    }

    public Double getSoe() {
        return soe;
    }

    public void setSoe(Double soe) {
        this.soe = soe;
    }

    public Double getPalochkoydernieGranulociti() {
        return palochkoydernieGranulociti;
    }

    public void setPalochkoydernieGranulociti(Double palochkoydernieGranulociti) {
        this.palochkoydernieGranulociti = palochkoydernieGranulociti;
    }

    public Double getSegmentoydernieGranulociti() {
        return segmentoydernieGranulociti;
    }

    public void setSegmentoydernieGranulociti(Double segmentoydernieGranulociti) {
        this.segmentoydernieGranulociti = segmentoydernieGranulociti;
    }

    public Double getEosinofiles() {
        return eosinofiles;
    }

    public void setEosinofiles(Double eosinofiles) {
        this.eosinofiles = eosinofiles;
    }

    public Double getBasofiles() {
        return basofiles;
    }

    public void setBasofiles(Double basofiles) {
        this.basofiles = basofiles;
    }

    public Double getLimfocities() {
        return limfocities;
    }

    public void setLimfocities(Double limfocities) {
        this.limfocities = limfocities;
    }

    public Double getMonocities() {
        return monocities;
    }

    public void setMonocities(Double monocities) {
        this.monocities = monocities;
    }

    public Double getMetolmielocites() {
        return metolmielocites;
    }

    public void setMetolmielocites(Double metolmielocites) {
        this.metolmielocites = metolmielocites;
    }

    public Double getMielocities() {
        return mielocities;
    }

    public void setMielocities(Double mielocities) {
        this.mielocities = mielocities;
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
        return "OAK{" +
               "id=" + id +
               ", userId=" + userId +
               ", rbc=" + rbc +
               ", wbc=" + wbc +
               ", trombocitis=" + trombocitis +
               ", hb=" + hb +
               ", hematocritis=" + hematocritis +
               ", cp=" + cp +
               ", reticulocitis=" + reticulocitis +
               ", soe=" + soe +
               ", palochkoydernieGranulociti=" + palochkoydernieGranulociti +
               ", segmentoydernieGranulociti=" + segmentoydernieGranulociti +
               ", eosinofiles=" + eosinofiles +
               ", basofiles=" + basofiles +
               ", limfocities=" + limfocities +
               ", monocities=" + monocities +
               ", metolmielocites=" + metolmielocites +
               ", mielocities=" + mielocities +
               ", getMatirial=" + getMatirial +
               ", addedResult=" + addedResult +
               '}';
    }


    public static final class OAKBuilder {
        private Integer id;
        private Integer userId;
        private Integer rbc;
        private Integer wbc;
        private Integer trombocitis;
        private Double hb;
        private Double hematocritis;
        private Double cp;
        private Double reticulocitis;
        private Double soe;
        private Double palochkoydernieGranulociti;
        private Double segmentoydernieGranulociti;
        private Double eosinofiles;
        private Double basofiles;
        private Double limfocities;
        private Double monocities;
        private Double metolmielocites;
        private Double mielocities;
        private LocalDateTime getMatirial;
        private LocalDateTime addedResult;

        private OAKBuilder() {
        }

        public static OAKBuilder anOAK() {
            return new OAKBuilder();
        }

        public OAKBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public OAKBuilder withUserId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public OAKBuilder withRbc(Integer rbc) {
            this.rbc = rbc;
            return this;
        }

        public OAKBuilder withWbc(Integer wbc) {
            this.wbc = wbc;
            return this;
        }

        public OAKBuilder withTrombocitis(Integer trombocitis) {
            this.trombocitis = trombocitis;
            return this;
        }

        public OAKBuilder withHb(Double hb) {
            this.hb = hb;
            return this;
        }

        public OAKBuilder withHematocritis(Double hematocritis) {
            this.hematocritis = hematocritis;
            return this;
        }

        public OAKBuilder withCp(Double cp) {
            this.cp = cp;
            return this;
        }

        public OAKBuilder withReticulocitis(Double reticulocitis) {
            this.reticulocitis = reticulocitis;
            return this;
        }

        public OAKBuilder withSoe(Double soe) {
            this.soe = soe;
            return this;
        }

        public OAKBuilder withPalochkoydernieGranulociti(Double palochkoydernieGranulociti) {
            this.palochkoydernieGranulociti = palochkoydernieGranulociti;
            return this;
        }

        public OAKBuilder withSegmentoydernieGranulociti(Double segmentoydernieGranulociti) {
            this.segmentoydernieGranulociti = segmentoydernieGranulociti;
            return this;
        }

        public OAKBuilder withEosinofiles(Double eosinofiles) {
            this.eosinofiles = eosinofiles;
            return this;
        }

        public OAKBuilder withBasofiles(Double basofiles) {
            this.basofiles = basofiles;
            return this;
        }

        public OAKBuilder withLimfocities(Double limfocities) {
            this.limfocities = limfocities;
            return this;
        }

        public OAKBuilder withMonocities(Double monocities) {
            this.monocities = monocities;
            return this;
        }

        public OAKBuilder withMetolmielocites(Double metolmielocites) {
            this.metolmielocites = metolmielocites;
            return this;
        }

        public OAKBuilder withMielocities(Double mielocities) {
            this.mielocities = mielocities;
            return this;
        }

        public OAKBuilder withGetMatirial(LocalDateTime getMatirial) {
            this.getMatirial = getMatirial;
            return this;
        }

        public OAKBuilder withAddedResult(LocalDateTime addedResult) {
            this.addedResult = addedResult;
            return this;
        }

        public OAK build() {
            OAK oAK = new OAK();
            oAK.setId(id);
            oAK.setUserId(userId);
            oAK.setRbc(rbc);
            oAK.setWbc(wbc);
            oAK.setTrombocitis(trombocitis);
            oAK.setHb(hb);
            oAK.setHematocritis(hematocritis);
            oAK.setCp(cp);
            oAK.setReticulocitis(reticulocitis);
            oAK.setSoe(soe);
            oAK.setPalochkoydernieGranulociti(palochkoydernieGranulociti);
            oAK.setSegmentoydernieGranulociti(segmentoydernieGranulociti);
            oAK.setEosinofiles(eosinofiles);
            oAK.setBasofiles(basofiles);
            oAK.setLimfocities(limfocities);
            oAK.setMonocities(monocities);
            oAK.setMetolmielocites(metolmielocites);
            oAK.setMielocities(mielocities);
            oAK.setGetMatirial(getMatirial);
            oAK.setAddedResult(addedResult);
            return oAK;
        }
    }
}

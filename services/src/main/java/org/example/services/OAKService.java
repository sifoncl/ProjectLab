package org.example.services;

import lombok.experimental.UtilityClass;
import org.example.dao.OAKDao;
import org.example.dao.entities.analysis.OAK;
import org.example.dto.OAKDto;

import java.util.List;

@UtilityClass
public class OAKService {

    public static List<OAKDto> getAllUserResults(Integer userId){
        return OAKDao.saveAllUserOAKResults(userId).stream().map(OAKService::mapper).toList();
    }
    public static OAKDto getById(Integer id){
        return mapper(OAKDao.getById(id));
    }
    private static OAKDto mapper(OAK o) {
        return OAKDto.builder()
                .id(o.getId())
                .userId(o.getUserId())
                .getMatirial(o.getGetMatirial().toString())
                .addedResult(o.getAddedResult().toString())
                .rbc(o.getRbc())
                .wbc(o.getWbc())
                .trombocitis(o.getTrombocitis())
                .hb(o.getHb())
                .hematocritis(o.getHematocritis())
                .cp(o.getCp())
                .reticulocitis(o.getReticulocitis())
                .soe(o.getSoe())
                .palochkoydernieGranulociti(o.getPalochkoydernieGranulociti())
                .segmentoydernieGranulociti(o.getSegmentoydernieGranulociti())
                .eosinofiles(o.getEosinofiles())
                .basofiles(o.getBasofiles())
                .limfocities(o.getLimfocities())
                .monocities(o.getMonocities())
                .metolmielocites(o.getMetolmielocites())
                .mielocities(o.getMielocities())
                .build();
    }
}

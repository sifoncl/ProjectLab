package org.example.services;

import lombok.experimental.UtilityClass;
import org.example.dao.BiochemicalDao;
import org.example.dao.entities.analysis.Biochemical;
import org.example.dto.BiochemicalDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@UtilityClass
public class BiochemicalService {
    public static List<BiochemicalDto> getAllUserResults(Integer userId) {
        return BiochemicalDao.saveAllUserBcResults(userId).stream()
                .map(BiochemicalService::mapper).toList();
    }

    public static BiochemicalDto getById (Integer id){
        return mapper(BiochemicalDao.getById(id));
    }




    private static BiochemicalDto mapper(Biochemical BcDao) {
        return BiochemicalDto.builder()
                .id(BcDao.getId())
                .userId(BcDao.getUserId())
                .ast(BcDao.getAst())
                .alt(BcDao.getAlt())
                .bilirubinObsh(BcDao.getBilirubinObsh())
                .bilirubinPriamoi(BcDao.getBilirubinPriamoi())
                .bilirubinNepriamoi(BcDao.getBilirubinNepriamoi())
                .glucose(BcDao.getGlucose())
                .creatinin(BcDao.getCholesterin())
                .mochevina(BcDao.getMochevina())
                .cholesterin(BcDao.getCholesterin())
                .getMatirial(BcDao.getGetMatirial().toString())
                .addedResult(BcDao.getAddedResult().toString())
                .build();
    }
}

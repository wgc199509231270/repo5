package com.OuSoft.system.service.Tactivity;


import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tactivity;

import java.util.List;

public interface TactivityService {

    ResponseModel insertTactivityService(Tactivity tactivity);

    List<Tactivity> queryListActivityService(Tactivity tactivity);

    ResponseModel delTactivityService(String id);

    ResponseModel updateTactivityService(Tactivity tactivity);

    ResponseModel insertTactivityUserService(Tactivity tactivity);

    List<Tactivity> queryListRegActivityService(Tactivity tactivity);

    ResponseModel delTactivityUserService(String id);

    ResponseModel updateTactivityUserService(Tactivity tactivity);

    List<Tactivity> queryDzTactivityuserRequestDao(Tactivity tactivity);
}

package com.OuSoft.system.service.Tsmenu;
import com.OuSoft.system.entity.ResponseModel;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.OuSoft.system.entity.Tsmenu;
import org.springframework.web.bind.annotation.RequestBody;

public interface ITsmenuService {

	List<Tsmenu> QueryTsmenuList();

	ResponseModel DelTsmenu(@Param("whetherpublic") String whetherpublic);

	Tsmenu QueryTsmenuByid(@Param("whetherpublic") String whetherpublic);

	ResponseModel UpdateTsmenuByid(@RequestBody Tsmenu model);

	ResponseModel InsertTsmenu(@RequestBody Tsmenu model);

}

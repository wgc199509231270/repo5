package com.OuSoft.system.dao.Tsmenu;
import com.OuSoft.system.entity.Tsmenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import com.OuSoft.system.entity.ResponseModel;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@Mapper
@Component(value = "Tsmenu")
public interface TsmenusDao {

	List<Tsmenu> QueryTsmenuList();

	ResponseModel DelTsmenu(@Param("id") String id);

	Tsmenu QueryTsmenuByid(@Param("id") String id);

	ResponseModel UpdateTsmenuByid(@RequestBody Tsmenu model);

	ResponseModel InsertTsmenu(@RequestBody Tsmenu model);

}

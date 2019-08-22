package com.mrspeak.springbootinit.dao;


import com.mrspeak.springbootinit.bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * @author allinibridge
 * @description 部门mapper
 * @date 2019/8/21
 */
@Mapper
public interface DepartmentMapper {

    /*@Select("select * from department where id = #{id}")*/
    Department getDepartment(Integer id);

    /*@Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) value(#departmentName)")*/
    int insertDep(Department department);

   /* @Delete("delete from department where id=#{id}")*/
    int delDep(Integer id);


}

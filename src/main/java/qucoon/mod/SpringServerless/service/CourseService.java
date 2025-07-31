
package   qucoon.mod.SpringServerless.service;


import qucoon.mod.SpringServerless.utility.exception.CustomExceptions;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;
import qucoon.mod.SpringServerless.utility.model.response.BaseResponse;
import qucoon.mod.SpringServerless.model.entity.User;
import qucoon.mod.SpringServerless.model.request.*;
import qucoon.mod.SpringServerless.model.response.*;
import qucoon.mod.SpringServerless.utility.LocalDateTimeTypeAdapter;
import qucoon.mod.SpringServerless.repository.*;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.CoursePage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.CourseDto;


@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private  final Gson GSON;


    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(CourseCreateRequest request) {
        //create service endpoint.
        Course course = GSON.fromJson(GSON.toJson(request), Course.class);
        if (course.getCourseStatus() == null) {
            course.setCourseStatus("ACTIVE");
        }
        courseRepository.create(course);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<CourseCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            Course[] courseArray = GSON.fromJson(json, Course[].class);
            List<Course> courses = Arrays.asList(courseArray);
            courseRepository.bulkCreate(courses);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(CourseUpdateRequest request) {
        Course course = courseRepository.readByCourseId(request.getCourseId());
        if (course == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        courseRepository.update(course);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int courseId) {
        int updateResponse = courseRepository.delete(courseId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public CourseReadListResponse read() {
        List<Course> courses = courseRepository.read();
       if(courses == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new CourseReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), courses);
    }
   public CourseReadPagedResponse search(CourseFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       CoursePage page = courseRepository.findCourse(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<CourseDto> dtos = page.getData().stream()
            .map(CourseDto::from)
            .collect(Collectors.toList());
    return new CourseReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public CourseReadSingleResponse readByCourseId(int courseid) {
        Course course = courseRepository.readByCourseId(courseid);
        if (course == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new CourseReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                course);
    }
    public CourseReadListResponse readByCourseUserId(int courseuserid) {
        List<Course> courses = courseRepository.readByCourseUserId(courseuserid);
        return new CourseReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        courses);
    }
    public CourseReadListResponse readByCourseName(String coursename) {
        List<Course> courses = courseRepository.readByCourseName(coursename);
        return new CourseReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        courses);
    }
    public CourseReadListResponse readByCourseDescription(String coursedescription) {
        List<Course> courses = courseRepository.readByCourseDescription(coursedescription);
        return new CourseReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        courses);
    }
    public CourseReadListResponse readByCourseStatus (String coursestatus ) {
        List<Course> courses = courseRepository.readByCourseStatus (coursestatus );
        return new CourseReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        courses);
    }
    public CourseReadListResponse readByCourseCreatedAt  (String coursecreatedat  ) {
        List<Course> courses = courseRepository.readByCourseCreatedAt  (coursecreatedat  );
        return new CourseReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        courses);
    }
    public CourseReadListResponse readByCourseUpdatedAt (String courseupdatedat ) {
        List<Course> courses = courseRepository.readByCourseUpdatedAt (courseupdatedat );
        return new CourseReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        courses);
    }
}

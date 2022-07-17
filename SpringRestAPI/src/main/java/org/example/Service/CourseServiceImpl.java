package org.example.Service;

import org.example.Entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private org.example.CourseDao.courseDao courseDao;

    /*List<Course> list;

   public CourseServiceImpl(){
       list = new ArrayList<>();
       list.add(new Course(101,"Core Java"," This is Core Java"));
       list.add(new Course(102,"Python"," This is Python"));
   */

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {
      /* Course c = null;
       for(Course course: list){
           if(course.getId() == courseId){
               c = course;
               break;
           }
       }*/
        Course c1 = courseDao.findById(courseId).get();
        return c1 ;
    }

    @Override
    public Course addCourse(Course course) {
      /* list.add(course);*/
        courseDao.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
       /*list.forEach( a-> {
           if(a.getId() == course.getId()){
               a.setTitle(course.getTitle());
               a.setDescription(course.getDescription());
           }
       });*/
        courseDao.save(course);
        return course;
    }

    @Override
    public void deleteCourse(Long courseId) {
//        Course entity = courseDao.getOne(courseId);
//       /*int count = 0;
//       for(int i=1; i< list.size()-1; i++){
//           if(list.contains(courseId)){
//               break;
//           }
//           count++;
//       }
//       list.remove(count);*/
        Course entity = courseDao.getReferenceById(courseId);
         courseDao.delete(entity);
    }
}

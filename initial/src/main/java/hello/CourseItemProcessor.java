package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

public class CourseItemProcessor implements ItemProcessor<CourseSchedule, CourseSchedule> {

    private static final Logger log = LoggerFactory.getLogger(CourseItemProcessor.class);

    @Override
    public CourseSchedule process(final CourseSchedule course) throws Exception {

        final int CRN= course.getCRN();
        final String subj = course.getsubj();
        final int curseNumber = course.getcurseNumber();
        final String term = course.getterm();
        final String title = course.gettitle();
        final String Dayyy=course.getDayyy();
        final  int StudentCapa=course.getStudentCapa();
        final String InstructorName=course.getInstructorName();


        final CourseSchedule transformedCourse = new CourseSchedule(CRN, subj, curseNumber, term,title , Dayyy, StudentCapa, InstructorName);

        log.info("Converting (" + course + ") into (" + transformedCourse + ")");

        return transformedCourse;
    }

}
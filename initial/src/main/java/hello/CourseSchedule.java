package hello;

public class CourseSchedule {
    private int CRN;
    private String subj;
    private int curseNumber;
    private String term;
    private String title;
    private String Dayyy;
    private int StudentCapa;
    private String InstructorName;

    public CourseSchedule() {

    }

    public CourseSchedule(int CRN,String subj, int curseNumber, String term, String title, String Dayyy, int StudentCapa, String InstructorName ) {
        this.CRN = CRN;
        this.subj = subj;
        this.curseNumber = curseNumber;
        this.term= term;
        this.title = title;
        this.Dayyy = Dayyy;
        this.StudentCapa = StudentCapa;
        this.InstructorName = InstructorName;
    }

    public void setCRN(int CRN) {
        this.CRN = CRN;
    }
    public int getCRN() {return CRN;}


    public void setsubj (String subj ) {this.subj = subj;}
    public String getsubj() { return  subj;}



    public void setcurseNumber(int curseNumber){this.curseNumber = curseNumber;}
    public int getcurseNumber() {return curseNumber;}



    public void setterm (String term) {this.term = term;}
    public String getterm() { return  term;}




    public void settitle (String title ) {this.title = title;}
    public String gettitle() { return  title;}





    public void setDayyy (String Dayyy ) {this.Dayyy = Dayyy;}
    public String getDayyy() { return  Dayyy;}


    public void setStudentCapa(int StudentCapa) {this.StudentCapa = StudentCapa;}
    public int getStudentCapa() {return StudentCapa;}


    public void setInstructorName (String InstructorName) {this.InstructorName = InstructorName;}
    public String getInstructorName() {return InstructorName;}

    @Override
    public String toString() {
        return "\n" + "CRN:" + CRN + ".  Department:" + subj + ".  CurseNumber:" + curseNumber + ".  Term:" + term + ".  Title:" + title + ".  Days:" + Dayyy +".  Capacte of Student:" + StudentCapa + ".  InstructorName:" + InstructorName+ "\n";
    }


}
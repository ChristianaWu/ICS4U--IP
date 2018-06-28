package edu.hdsb.gwss.ics4u.pt;

/**
 * Computer Science Student
 *
 * DO NOT CHANGE
 * 
 * @version v2018.S2
 */
public class CSStudent {

    private String firstName;
    private String lastName;
    private int studentNumber;
    private int grade;

    /**
     * Computer Science Student
     *
     * @param firstName first name of student
     * @param lastName last name of the student
     * @param studentNumber student number, unique id (key)
     * @param grade grade
     */
    public CSStudent( String firstName, String lastName, int studentNumber, int grade ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.grade = grade;
    }

    /**
     * Get first name.
     *
     * @return returns the first name of the student
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set first name
     *
     * @param firstName the first name of the student
     */
    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }

    /**
     * Get last name.
     *
     * @return returns the last name of the student
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set last name
     *
     * @param lastName the last name of the student
     */
    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }

    /**
     * Get the student number.
     *
     * @return student number, a unique identifier (key)
     */
    public int getStudentNumber() {
        return studentNumber;
    }

    /**
     * Get the student number.
     *
     * @param studentNumber student number, a unique identifier (key)
     */
    public void setStudentNumber( int studentNumber ) {
        this.studentNumber = studentNumber;
    }

    /**
     * Get the grade the student is in.
     *
     * @return the grade the student is in
     */
    public int getGrade() {
        return grade;
    }

    /**
     * Set the grade.
     *
     * @param grade the grade the student is in.
     */
    public void setGrade( int grade ) {
        this.grade = grade;
    }

    /**
     * The method returns the KEY (student number).
     *
     * @return returns the student KEY (student number)
     */
    public int getKey() {
        return getStudentNumber();
    }

    @Override
    public String toString() {
        return "S# " + studentNumber + " : " + firstName + " " + lastName;
    }

    @Override
    public boolean equals( Object obj ) {
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        final CSStudent other = (CSStudent) obj;
        if ( this.studentNumber != other.studentNumber ) {
            return false;
        }
        return true;
    }

}

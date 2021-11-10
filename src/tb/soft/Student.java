package tb.soft;

enum PersonJob {
    UNKNOWN("-------"),
    GUEST("Gość"),
    STUDENT("Student"),
    TEACHER("Nauczyciel"),
    MANAGER("Kierownik"),
    DIRECTOR("Dyrektor");

    String jobName;

    private PersonJob(String job_name) {
        jobName = job_name;
    }


    @Override
    public String toString() {
        return jobName;
    }

}





public class Student {


    private String firstName;
    private String lastName;
    private int birthYear;
    private PersonJob job;




    public Student(String first_name, String last_name) throws PersonException {
        setFirstName(first_name);
        setLastName(last_name);
        job = PersonJob.UNKNOWN;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String first_name) throws PersonException {
        if ((first_name == null) || first_name.equals(""))
            throw new PersonException("Pole <Imię> musi być wypełnione.");
        this.firstName = first_name;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String last_name) throws PersonException {
        if ((last_name == null) || last_name.equals(""))
            throw new PersonException("Pole <Nazwisko> musi być wypełnione.");
        this.lastName = last_name;
    }


    public int getBirthYear() {
        return birthYear;
    }


    public void setBirthYear(int birth_year) throws PersonException {
        if ((birth_year!=0) && (birth_year < 1900 || birth_year > 2030))
            throw new PersonException("Rok urodzenia musi być w przedziale [1900 - 2030].");
        this.birthYear = birth_year;
    }


    public void setBirthYear(String birth_year) throws PersonException {
        if (birth_year == null || birth_year.equals("")){  // pusty łańcuch znaków oznacza rok niezdefiniowany
            setBirthYear(0);
            return;
        }
        try {
            setBirthYear(Integer.parseInt(birth_year));
        } catch (NumberFormatException e) {
            throw new PersonException("Rok urodzenia musi być liczbą całkowitą.");
        }
    }


    public PersonJob getJob() {
        return job;
    }


    public void setJob(PersonJob job){
        this.job = job;
    }


    public void setJob(String job_name) throws PersonException {
        if (job_name == null || job_name.equals("")) {  // pusty łańcuch znaków oznacza stanowisko niezdefiniowane
            this.job = PersonJob.UNKNOWN;
            return;
        }
        for(PersonJob job : PersonJob.values()){
            if (job.jobName.equals(job_name)) {
                this.job = job;
                return;
            }
        }
        throw new PersonException("Nie ma takiego stanowiska.");
    }


    @Override
    public String toString() {
        return firstName + " " + lastName + " " + birthYear + " " + job;
    }



    class PersonException extends Exception {

        private static final long serialVersionUID = 1L;

        public PersonException(String message) {
            super(message);
        }
}

    @Override
    public int hashCode() {
        int result = 7;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + birthYear;
        return result;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        ;
        if (object == null) {
            return false;
        }
        if (object instanceof Student) {
            Student s = (Student) object;
            if (firstName.equals(s.firstName) && lastName.equals(s.lastName) && birthYear == s.birthYear) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}



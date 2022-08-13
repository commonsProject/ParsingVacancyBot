package dataStructures;

import java.util.Objects;

public class Vacancy {
    // надо написать поля, геттеры и сеттеры для полей, переопределить
    // методы tostring(), equals(), hashcode()package dataStructures;

    private String region;                  //Регион
    private String company;                 //Компания
    private String industryOfCompany;       //Отрасль компании
    private String speciality;              //Специальность
    private String jobTitle;                //Должность
    private String schedule;                //График работы
    private int salary;                     //Зарплата
    private String workExperience;          //Опыт работы

    public Vacancy(String region, String company, String industryOfCompany, String speciality, String jobTitle, String schedule, int salary, String workExperience) {
        this.region = region;
        this.company = company;
        this.industryOfCompany = industryOfCompany;
        this.speciality = speciality;
        this.jobTitle = jobTitle;
        this.schedule = schedule;
        this.salary = salary;
        this.workExperience = workExperience;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getIndustryOfCompany() {
        return industryOfCompany;
    }

    public void setIndustryOfCompany(String industryOfCompany) {
        this.industryOfCompany = industryOfCompany;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacancy vacancy = (Vacancy) o;
        return salary == vacancy.salary && Objects.equals(region, vacancy.region) && Objects.equals(company, vacancy.company) && Objects.equals(industryOfCompany, vacancy.industryOfCompany) && Objects.equals(speciality, vacancy.speciality) && Objects.equals(jobTitle, vacancy.jobTitle) && Objects.equals(schedule, vacancy.schedule) && Objects.equals(workExperience, vacancy.workExperience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(region, company, industryOfCompany, speciality, jobTitle, schedule, salary, workExperience);
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "Регион = " + region + '\'' +
                ", Компания = " + company + '\'' +
                ", Отрасль компании = " + industryOfCompany + '\'' +
                ", Специальность = " + speciality + '\'' +
                ", Должность = " + jobTitle + '\'' +
                ", График работы = " + schedule + '\'' +
                ", Зарплата = " + salary +
                ", Опыт работы = " + workExperience + '\'' +
                '}';
    }
}

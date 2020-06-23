package com.company;

import java.util.List;

import java.util.List;

public class Company implements ICompanyService{

    private Company parent;      // parent for this company is nullable,
    // when there is no parent for this company
    private long employeesCount;


    /*
     * @param Constructor, Getters, Setters, toString
     *
     * @return - taking into this class - Constructor, Getters, Setters, toString
     *
     */
    public Company() {
    }

    public Company(Company parent, long employeesCount) {
        this.parent = parent;
        this.employeesCount = employeesCount;
    }

    public Company getParent() {
        return parent;
    }

    public void setParent(Company parent) {
        this.parent = parent;
    }

    public long getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(long employeesCount) {
        this.employeesCount = employeesCount;
    }

    @Override
    public String toString() {
        return "Company{" +
                "parent=" + parent +
                ", employeesCount=" + employeesCount +
                '}';
    }

    /*
     * @param getTopLevelParent - method for Company.
     *
     * @return - top level parent of Company,
     *
     */
    @Override
    public Company getTopLevelParent(Company child) throws CloneNotSupportedException {
        Company a = child;
        while (a.getParent() != null){
            a = a.getParent();
        }
        return a;
    }


    /*
     * @param method getEmployeeCountForCompanyAndChildren.
     *
     * @return - number of employees
     *
     */
    @Override
    public long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies) {
        long EmployeeCountForCompanyAndChildren = company.getEmployeesCount();
        for (Company company1 : companies) {
            if (company == company1.getParent()) {
                EmployeeCountForCompanyAndChildren += company1.getEmployeesCount();
            }
        }
        return EmployeeCountForCompanyAndChildren;

    }
}
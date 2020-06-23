package com.company;

import java.nio.file.Paths;
import java.util.List;

public class CompanyServiceImpl implements ICompanyService {

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
        if (child.getParent() == null){
            return child.getParent();
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
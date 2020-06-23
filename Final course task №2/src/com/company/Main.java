/*
 *
 * Classname Main
 *
 *  23 June 2020
 *
 * Copyright Holovey Ivan
 *
 * 2. COMPANY Service implementation
 *
 * 1. Create a test set of companies in your main class.
 * 2. Take for this set IT-companies: Chief, Lawyer, Developer
 * (Design,  Front-end, Back-end, DevOps). See attach.
 * 3. Take into account 4 different cases for a company
 * (on-top, on bottom, in the node, out of chain).
 * 4. Test all this cases in your main class.
 * 5. Implement the interface in a class CompanyService.
 *
 * */
package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        /*
         * @param companies - list for companies and adding companies.
         *
         * @return - adding list of companies.
         */
        List<Company> companies = new ArrayList<>();
        Company chief = new Company(null, 25L);
        companies.add(chief);

        Company developer = new Company(chief, 20L);
        companies.add(developer);

        Company backend = new Company(developer, 5L);
        companies.add(backend);

        Company devops = new Company(backend, 2L);
        companies.add(devops);

        Company frontend = new Company(developer, 5L);
        companies.add(frontend);

        Company design = new Company(frontend, 2L);
        companies.add(design);

        Company accounting = new Company(null,5L);
        companies.add(accounting);

        Company lawyer = new Company(chief,5L);
        companies.add(lawyer);

        /*
         * @param service - ICompanyServiceImpl service.
         *
         * @return - methods of CompanyServiceImpl of some of IT companies
         */

        CompanyServiceImpl service = new CompanyServiceImpl();

        // Printing for method getTopLevelParent

        System.out.println(service
                .getTopLevelParent(chief));
        System.out.println(service
                .getTopLevelParent(developer));
        System.out.println(service
                .getTopLevelParent(backend));
        System.out.println(service
                .getTopLevelParent(devops));
        System.out.println(service
                .getTopLevelParent(frontend));
        System.out.println(service
                .getTopLevelParent(design));
        System.out.println(service
                .getTopLevelParent(accounting));
        System.out.println(service
                .getTopLevelParent(lawyer));

        // Printing for method getTopLevelParent

        System.out.println(chief
                .getEmployeeCountForCompanyAndChildren(chief, companies));
        System.out.println(chief
                .getEmployeeCountForCompanyAndChildren(developer, companies));
        System.out.println(chief
                .getEmployeeCountForCompanyAndChildren(backend, companies));
        System.out.println(chief
                .getEmployeeCountForCompanyAndChildren(devops, companies));
        System.out.println(chief
                .getEmployeeCountForCompanyAndChildren(frontend, companies));
        System.out.println(chief
                .getEmployeeCountForCompanyAndChildren(design, companies));
        System.out.println(chief
                .getEmployeeCountForCompanyAndChildren(accounting, companies));
        System.out.println(chief
                .getEmployeeCountForCompanyAndChildren(lawyer, companies));


    }
}

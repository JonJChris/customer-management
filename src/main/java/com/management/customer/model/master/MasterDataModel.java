package com.management.customer.model.master;

import java.util.List;

public record MasterDataModel(List<RequestTypeModel> requestTypeModelList,
                              List<CountryModel> countryModelList,
                              List<CustomerStatusModel> customerStatusModelList,
                              List<CustomerTypeModel> customerTypeModelList,
                              List<EducationLevelModel> educationLevelsList,
                              List<EmploymentStatusModel> employmentStatusModelList,
                              List<MaritalStatusModel> maritalStatusModelList,
                              List<ProfessionModel> professionModelList,
                              List<StageTypeModel> stageTypeModelList,
                              List<TitleModel> titleModelList,
                              List<YearlyIncomeModel> yearlyIncomeModelList,
                              List<RelationshipTypeModel> relationshipTypeModelList,
                              List<HomeOwnershipTypeModel> homeOwnershipTypeModelList,
                              List<ProductModel> productModelList,
                              List<BranchModel> branchModelList,
                              List<DocumentTypeModel> documentTypeModelList

) {
}

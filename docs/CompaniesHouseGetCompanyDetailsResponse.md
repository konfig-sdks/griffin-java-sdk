

# CompaniesHouseGetCompanyDetailsResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**companyAddress** | [**CompanyAddressProperty**](CompanyAddressProperty.md) |  |  [optional] |
|**dateOfLatestAccounts** | **LocalDate** | ISO 8601 formatted date. |  [optional] |
|**entityName** | **String** |  |  |
|**directors** | [**List&lt;Director&gt;**](Director.md) |  |  |
|**dateOfLatestConfirmationStatement** | **LocalDate** | ISO 8601 formatted date. |  [optional] |
|**corporationType** | [**CorporationTypeEnum**](#CorporationTypeEnum) |  |  |
|**companyStatus** | [**CompanyStatusEnum**](#CompanyStatusEnum) |  |  |
|**accountsOverdue** | **Boolean** |  |  [optional] |
|**sicCodes** | **List&lt;String&gt;** |  |  [optional] |
|**personsWithSignificantControl** | [**List&lt;PersonWithSignificantControl&gt;**](PersonWithSignificantControl.md) |  |  |
|**confirmationStatementOverdue** | **Boolean** |  |  [optional] |
|**dateOfIncorporation** | **LocalDate** | ISO 8601 formatted date. |  |
|**entityRegistrationNumber** | **String** | The entity number assigned by the local register. For UK companies that&#39;s the Companies House company number. |  |



## Enum: CorporationTypeEnum

| Name | Value |
|---- | -----|
| PRIVATE_LIMITED_GUARANT_NSC_LIMITED_EXEMPTION | &quot;private-limited-guarant-nsc-limited-exemption&quot; |
| EEIG | &quot;eeig&quot; |
| PRIVATE_LIMITED_SHARES_SECTION_30_EXEMPTION | &quot;private-limited-shares-section-30-exemption&quot; |
| LIMITED_PARTNERSHIP | &quot;limited-partnership&quot; |
| ROYAL_CHARTER | &quot;royal-charter&quot; |
| PRIVATE_UNLIMITED_NSC | &quot;private-unlimited-nsc&quot; |
| OLD_PUBLIC_COMPANY | &quot;old-public-company&quot; |
| INVESTMENT_COMPANY_WITH_VARIABLE_CAPITAL | &quot;investment-company-with-variable-capital&quot; |
| OTHER_COMPANY_TYPE | &quot;other-company-type&quot; |
| CONVERTED_OR_CLOSED | &quot;converted-or-closed&quot; |
| PROTECTED_CELL_COMPANY | &quot;protected-cell-company&quot; |
| PRIVATE_LIMITED_GUARANT_NSC | &quot;private-limited-guarant-nsc&quot; |
| SCOTTISH_CHARITABLE_INCORPORATED_ORGANISATION | &quot;scottish-charitable-incorporated-organisation&quot; |
| INDUSTRIAL_AND_PROVIDENT_SOCIETY | &quot;industrial-and-provident-society&quot; |
| REGISTERED_SOCIETY_NON_JURISDICTIONAL | &quot;registered-society-non-jurisdictional&quot; |
| PRIVATE_UNLIMITED | &quot;private-unlimited&quot; |
| FURTHER_EDUCATION_OR_SIXTH_FORM_COLLEGE_CORPORATION | &quot;further-education-or-sixth-form-college-corporation&quot; |
| LIMITED_LIABILITY_PARTNERSHIP | &quot;limited-liability-partnership&quot; |
| ASSURANCE_COMPANY | &quot;assurance-company&quot; |
| OTHER | &quot;other&quot; |
| NORTHERN_IRELAND_OTHER | &quot;northern-ireland-other&quot; |
| CHARITABLE_INCORPORATED_ORGANISATION | &quot;charitable-incorporated-organisation&quot; |
| OVERSEA_COMPANY | &quot;oversea-company&quot; |
| ICVC_SECURITIES | &quot;icvc-securities&quot; |
| UK_ESTABLISHMENT | &quot;uk-establishment&quot; |
| UNREGISTERED_COMPANY | &quot;unregistered-company&quot; |
| ICVC_WARRANT | &quot;icvc-warrant&quot; |
| REGISTERED_OVERSEAS_ENTITY | &quot;registered-overseas-entity&quot; |
| PUBLIC_LIMITED_COMPANY | &quot;public-limited-company&quot; |
| PRIVATE_LIMITED_COMPANY | &quot;private-limited-company&quot; |
| EUROPEAN_PUBLIC_LIMITED_LIABILITY_COMPANY_SE | &quot;european-public-limited-liability-company-se&quot; |
| PRIVATE_UNLIMTED_NSC | &quot;private-unlimted-nsc&quot; |
| NORTHERN_IRELAND | &quot;northern-ireland&quot; |
| ICVC_UMBRELLA | &quot;icvc-umbrella&quot; |
| SCOTTISH_PARTNERSHIP | &quot;scottish-partnership&quot; |



## Enum: CompanyStatusEnum

| Name | Value |
|---- | -----|
| DISSOLVED | &quot;dissolved&quot; |
| ACTIVE | &quot;active&quot; |
| RECEIVERSHIP | &quot;receivership&quot; |
| REGISTERED | &quot;registered&quot; |
| REMOVED | &quot;removed&quot; |
| ADMINISTRATION | &quot;administration&quot; |
| OPEN | &quot;open&quot; |
| CLOSED | &quot;closed&quot; |
| VOLUNTARY_ARRANGEMENT | &quot;voluntary-arrangement&quot; |
| LIQUIDATION | &quot;liquidation&quot; |
| CONVERTED_CLOSED | &quot;converted-closed&quot; |
| INSOLVENCY_PROCEEDINGS | &quot;insolvency-proceedings&quot; |




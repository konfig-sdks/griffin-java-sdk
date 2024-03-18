

# MobileNumber3


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**mobileNumber** | **Object** |  |  [optional] |
|**claimType** | [**ClaimTypeEnum**](#ClaimTypeEnum) |  |  |
|**dateOfBirth** | **LocalDate** | ISO 8601 formatted date. |  [optional] |
|**givenName** | **String** |  |  [optional] |
|**surname** | **String** |  |  [optional] |
|**middleName** | **String** |  |  [optional] |
|**tradingName** | **String** |  |  [optional] |
|**tradingAddress** | [**BothBuildingNameAndBuildingNumberProperty**](BothBuildingNameAndBuildingNumberProperty.md) |  |  [optional] |
|**emailAddress** | **Object** |  |  [optional] |
|**city** | **String** |  |  [optional] |
|**buildingName** | **String** |  |  [optional] |
|**streetName** | **String** |  |  [optional] |
|**entityName** | **String** |  |  [optional] |
|**postalCode** | **String** |  |  [optional] |
|**corporationType** | [**CorporationTypeEnum**](#CorporationTypeEnum) |  |  [optional] |
|**telephoneNumber** | **Object** |  |  [optional] |
|**buildingNumber** | **String** |  |  [optional] |
|**countryCode** | **Object** |  |  [optional] |
|**dateOfIncorporation** | **LocalDate** | ISO 8601 formatted date. |  [optional] |
|**entityRegistrationNumber** | **String** | The entity number assigned by the local register. For UK companies that&#39;s the Companies House company number. |  [optional] |
|**income** | [**IncomeProperty4**](IncomeProperty4.md) |  |  [optional] |
|**initialDeposit** | [**InitialDepositProperty4**](InitialDepositProperty4.md) |  |  [optional] |
|**internationalPaymentsCountries** | **List&lt;Object&gt;** |  |  [optional] |
|**legalPersonUrl** | **String** | A contextual link to the [legal person](http://docs.griffin.com). |  [optional] |
|**ownershipPercent** | **String** | The percentage ownership the legal person has of the corporation. |  [optional] |
|**companiesHouseUrl** | **String** | The URL of the entity in Companies House |  [optional] |
|**seniorManagerQuestionMark** | **Boolean** |  |  [optional] |
|**taxResidency** | **Object** | ISO 3166-1 alpha-2 two-letter country code. |  [optional] |
|**ukRegulatoryPermissions** | [**List&lt;UkRegulatoryPermissionsEnum&gt;**](#List&lt;UkRegulatoryPermissionsEnum&gt;) |  |  [optional] |
|**businessDescription** | **String** |  |  [optional] |
|**individualSourcesOfFunds** | [**Set&lt;IndividualSourcesOfFundsEnum&gt;**](#Set&lt;IndividualSourcesOfFundsEnum&gt;) |  |  [optional] |
|**businessAddress** | [**BothBuildingNameAndBuildingNumberProperty**](BothBuildingNameAndBuildingNumberProperty.md) |  |  [optional] |
|**annualTurnover** | [**AnnualTurnoverProperty4**](AnnualTurnoverProperty4.md) |  |  [optional] |
|**purposesOfAccount** | [**Set&lt;PurposesOfAccountEnum&gt;**](#Set&lt;PurposesOfAccountEnum&gt;) |  |  [optional] |
|**sicCodes** | **List&lt;String&gt;** |  |  [optional] |
|**internationalOperationsCountries** | **List&lt;Object&gt;** |  |  [optional] |
|**sourcesOfFunds** | [**Set&lt;SourcesOfFundsEnum&gt;**](#Set&lt;SourcesOfFundsEnum&gt;) |  |  [optional] |
|**relianceVerificationMethods** | [**Set&lt;RelianceVerificationMethodsEnum&gt;**](#Set&lt;RelianceVerificationMethodsEnum&gt;) |  |  [optional] |
|**relianceVerificationStandard** | [**RelianceVerificationStandardEnum**](#RelianceVerificationStandardEnum) |  |  [optional] |
|**businessName** | **String** |  |  [optional] |
|**individualPurposesOfAccount** | [**Set&lt;IndividualPurposesOfAccountEnum&gt;**](#Set&lt;IndividualPurposesOfAccountEnum&gt;) |  |  [optional] |
|**nationality** | **Object** | ISO 3166-1 alpha-2 two-letter country code. |  [optional] |
|**socialMedia** | **String** |  |  [optional] |
|**websiteUrl** | **String** |  |  [optional] |
|**taxIdentificationNumber** | **String** |  |  [optional] |



## Enum: ClaimTypeEnum

| Name | Value |
|---- | -----|
| MOBILE_NUMBER | &quot;mobile-number&quot; |



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



## Enum: List&lt;UkRegulatoryPermissionsEnum&gt;

| Name | Value |
|---- | -----|
| ELECTRONIC_MONEY_INSTITUTION | &quot;electronic-money-institution&quot; |
| PAYMENT_INSTITUTION | &quot;payment-institution&quot; |
| CLIENT_MONEY | &quot;client-money&quot; |
| BANK | &quot;bank&quot; |



## Enum: Set&lt;IndividualSourcesOfFundsEnum&gt;

| Name | Value |
|---- | -----|
| GAMBLING_OR_LOTTERY | &quot;gambling-or-lottery&quot; |
| INVESTMENTS | &quot;investments&quot; |
| PROPERTY_OR_ASSET_SALE | &quot;property-or-asset-sale&quot; |
| SAVINGS | &quot;savings&quot; |
| SALARY_OR_BONUS | &quot;salary-or-bonus&quot; |
| STUDENT_LOANS_OR_BURSARY | &quot;student-loans-or-bursary&quot; |
| RETIREMENT_OR_PENSION | &quot;retirement-or-pension&quot; |
| LEGAL_SETTLEMENT | &quot;legal-settlement&quot; |
| FAMILY_OR_GIFTED | &quot;family-or-gifted&quot; |
| LOAN | &quot;loan&quot; |
| INHERITANCE | &quot;inheritance&quot; |



## Enum: Set&lt;PurposesOfAccountEnum&gt;

| Name | Value |
|---- | -----|
| SHORT_TERM_INVESTMENT | &quot;short-term-investment&quot; |
| LONG_TERM_INVESTMENT | &quot;long-term-investment&quot; |
| SAFEGUARDING | &quot;safeguarding&quot; |
| STAFF_PAYROLL | &quot;staff-payroll&quot; |
| CLIENT_MONEY | &quot;client-money&quot; |
| BUSINESS_EXPENSES | &quot;business-expenses&quot; |
| RECEIVING_PAYMENTS | &quot;receiving-payments&quot; |
| OPERATIONAL_SPEND | &quot;operational-spend&quot; |



## Enum: Set&lt;SourcesOfFundsEnum&gt;

| Name | Value |
|---- | -----|
| GAMBLING_OR_LOTTERY | &quot;gambling-or-lottery&quot; |
| INVESTMENTS | &quot;investments&quot; |
| PROPERTY_OR_ASSET_SALE | &quot;property-or-asset-sale&quot; |
| BUSINESS_INCOME | &quot;business-income&quot; |
| SAVINGS | &quot;savings&quot; |
| SALARY_OR_BONUS | &quot;salary-or-bonus&quot; |
| STUDENT_LOANS_OR_BURSARY | &quot;student-loans-or-bursary&quot; |
| RETIREMENT_OR_PENSION | &quot;retirement-or-pension&quot; |
| LEGAL_SETTLEMENT | &quot;legal-settlement&quot; |
| FAMILY_OR_GIFTED | &quot;family-or-gifted&quot; |
| LOAN | &quot;loan&quot; |
| INHERITANCE | &quot;inheritance&quot; |



## Enum: Set&lt;RelianceVerificationMethodsEnum&gt;

| Name | Value |
|---- | -----|
| MANUAL_DOCUMENT | &quot;manual-document&quot; |
| PHYSICAL | &quot;physical&quot; |
| ELECTRONIC | &quot;electronic&quot; |
| MANUAL_BIOMETRIC | &quot;manual-biometric&quot; |



## Enum: RelianceVerificationStandardEnum

| Name | Value |
|---- | -----|
| JMLSG | &quot;jmlsg&quot; |



## Enum: Set&lt;IndividualPurposesOfAccountEnum&gt;

| Name | Value |
|---- | -----|
| SAVINGS | &quot;savings&quot; |
| BILLS_AND_REPAYMENT | &quot;bills-and-repayment&quot; |
| EVERYDAY_SPENDING | &quot;everyday-spending&quot; |




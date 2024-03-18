

# WorkflowsGetWorkflowResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**workflowUrl** | **String** | A link to the [workflow](http://docs.griffin.com). |  |
|**displayName** | **String** | A human readable label for an entity |  |
|**legalPersonType** | [**LegalPersonTypeEnum**](#LegalPersonTypeEnum) | Specifies if the legal person is an &#x60;individual&#x60; or a &#x60;corporation&#x60;. |  |
|**createdAt** | **OffsetDateTime** | ISO 8601 formatted date-time. |  |
|**requiredClaimTypes** | [**Map&lt;String, Set&lt;String&gt;&gt;**](#Map&lt;String, Set&lt;String&gt;&gt;) | A mapping of workflow-appropriate legal person types                                  to claims that are required for each type. |  [optional] |
|**workflowRules** | [**Set&lt;WorkflowRulesEnum&gt;**](#Set&lt;WorkflowRulesEnum&gt;) | A list of special behaviours a workflow can possess. |  [optional] |



## Enum: LegalPersonTypeEnum

| Name | Value |
|---- | -----|
| INDIVIDUAL | &quot;individual&quot; |
| CORPORATION | &quot;corporation&quot; |



## Enum: Map&lt;String, Set&lt;String&gt;&gt;

| Name | Value |
|---- | -----|
| MOBILE_NUMBER | &quot;mobile-number&quot; |
| INDIVIDUAL_IDENTITY | &quot;individual-identity&quot; |
| SOLE_TRADER | &quot;sole-trader&quot; |
| UK_COMPANY_REGISTER | &quot;uk-company-register&quot; |
| INDIVIDUAL_INCOME | &quot;individual-income&quot; |
| BUSINESS_WEBSITE | &quot;business-website&quot; |
| INITIAL_DEPOSIT | &quot;initial-deposit&quot; |
| INTERNATIONAL_PAYMENTS_COUNTRIES | &quot;international-payments-countries&quot; |
| COMPANY_TELEPHONE_NUMBER | &quot;company-telephone-number&quot; |
| MANAGED_PROPERTIES | &quot;managed-properties&quot; |
| PERSON_WITH_SIGNIFICANT_CONTROL | &quot;person-with-significant-control&quot; |
| TENANT_CASH_PAYMENTS | &quot;tenant-cash-payments&quot; |
| VERIFIED_BANK_ACCOUNT | &quot;verified-bank-account&quot; |
| COMPANY_EMAIL_ADDRESS | &quot;company-email-address&quot; |
| TAX_RESIDENCY | &quot;tax-residency&quot; |
| UK_FINANCIAL_SERVICES_REGISTER | &quot;uk-financial-services-register&quot; |
| NON_TENANT_BALANCE | &quot;non-tenant-balance&quot; |
| BUSINESS_DESCRIPTION | &quot;business-description&quot; |
| HMRC_REGISTER | &quot;hmrc-register&quot; |
| BUSINESS_EMAIL_ADDRESS | &quot;business-email-address&quot; |
| CLIENT_MONEY_PROTECTION_SCHEME | &quot;client-money-protection-scheme&quot; |
| INDIVIDUAL_SOURCES_OF_FUNDS | &quot;individual-sources-of-funds&quot; |
| HMO_VERIFICATION | &quot;hmo-verification&quot; |
| BUSINESS_ADDRESS | &quot;business-address&quot; |
| EMPLOYMENT | &quot;employment&quot; |
| ANNUAL_TURNOVER | &quot;annual-turnover&quot; |
| PURPOSES_OF_ACCOUNT | &quot;purposes-of-account&quot; |
| SIC_CODES | &quot;sic-codes&quot; |
| INTERNATIONAL_OPERATIONS_COUNTRIES | &quot;international-operations-countries&quot; |
| SOURCES_OF_FUNDS | &quot;sources-of-funds&quot; |
| BUSINESS_OWNER | &quot;business-owner&quot; |
| BUSINESS_TELEPHONE_NUMBER | &quot;business-telephone-number&quot; |
| INDIVIDUAL_EMAIL_ADDRESS | &quot;individual-email-address&quot; |
| BUSINESS_START_DATE | &quot;business-start-date&quot; |
| CONTACT_DETAILS | &quot;contact-details&quot; |
| RELIANCE_VERIFICATION | &quot;reliance-verification&quot; |
| ULTIMATE_BENEFICIAL_OWNER | &quot;ultimate-beneficial-owner&quot; |
| BUSINESS_NAME | &quot;business-name&quot; |
| INDIVIDUAL_PURPOSES_OF_ACCOUNT | &quot;individual-purposes-of-account&quot; |
| NATIONALITY | &quot;nationality&quot; |
| TRADING_NAME | &quot;trading-name&quot; |
| NUMBER_OF_EMPLOYEES | &quot;number-of-employees&quot; |
| SOCIAL_MEDIA | &quot;social-media&quot; |
| TRADING_ADDRESS | &quot;trading-address&quot; |
| COMPANY_WEBSITE | &quot;company-website&quot; |
| DIRECTOR | &quot;director&quot; |
| ALTERNATIVE_NUMBER | &quot;alternative-number&quot; |
| TAX_IDENTIFICATION_NUMBER | &quot;tax-identification-number&quot; |
| INDIVIDUAL_RESIDENCE | &quot;individual-residence&quot; |



## Enum: Set&lt;WorkflowRulesEnum&gt;

| Name | Value |
|---- | -----|
| ZERO_DIRECTORS | &quot;allow-zero-directors&quot; |
| MISSING_DIRECTORS | &quot;allow-missing-directors&quot; |




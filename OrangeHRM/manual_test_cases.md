User Story : US-001 : OrangeHRM Login Page

Test Scenario : TS-001 : Verify Login Functionality


| Test Case ID | Priority | Test Case Scenario| Pre-Requisite  | Test Case | Test Case Steps                                                             | Test Data| Expected Result | Actual Result| Status | Comment |

| TC-Login-001       | High     | Verify login with valid credentials               | Browser launched and OrangeHRM URL opened | Verify login using valid username and password           | 1. Open URL 2. Enter valid username 3. Enter valid password 4. Click Login    | Username: Admin Password: admin123          | User should successfully login and navigate to Dashboard page        | User navigated to Dashboard page | Pass   | NA                  |

| TC-Login-002       | High     | Verify logout functionality                       | User logged into application              | Verify logout from application                           | 1. Login successfully 2. Click Profile icon 3. Click Logout                   | Username: Admin Password: admin123          | User should be redirected to Login page                              | User redirected to Login page    | Pass   | NA                  |
| TC-Login-003       | High     | Verify login with invalid password                | Browser launched and URL opened           | Verify login using valid username and invalid password   | 1. Open URL 2. Enter valid username 3. Enter invalid password 4. Click Login  | Username: Admin Password: Wrong123          | Error message "Invalid credentials" should be displayed              | Error message displayed          | Pass   | Negative Test       |

| TC-Login-004       | High     | Verify login with invalid username                | Browser launched and URL opened           | Verify login using invalid username and valid password   | 1. Open URL 2. Enter invalid username 3. Enter valid password 4. Click Login  | Username: Admin123 Password: admin123       | Error message "Invalid credentials" should be displayed              | Error message displayed          | Pass   | Negative Test       |

| TC-Login-005       | High     | Verify login with blank username and password     | Browser launched and URL opened           | Verify login without entering credentials                | 1. Open URL 2. Leave Username blank 3. Leave Password blank 4. Click Login    | NA                                          | Required validation message should be displayed                      | Validation message displayed     | Pass   | Negative Test       |

| TC-Login-006       | Medium   | Verify login with blank password                  | Browser launched and URL opened           | Verify login using username only                         | 1. Open URL 2. Enter valid username 3. Leave password blank 4. Click Login    | Username: Admin                             | Password field should display "Required" validation message          | Validation message displayed     | Pass   | Negative Test       |

| TC-Login-007       | Medium   | Verify login with blank username                  | Browser launched and URL opened           | Verify login using password only                         | 1. Open URL 2. Leave username blank 3. Enter valid password 4. Click Login    | Password: admin123                          | Username field should display "Required" validation message          | Validation message displayed     | Pass   | Negative Test       |

| TC-Login-008       | Low      | Verify maximum character length in username field | Browser launched and URL opened           | Verify application behavior with maximum username length | 1. Open URL 2. Enter maximum length username 3. Enter password 4. Click Login | Username: 50+ Characters Password: admin123 | System should handle input properly and display appropriate response | As per application behavior      | Pass   | Boundary Value Test |

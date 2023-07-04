### Requirements:

1. **User Management:**
    - Functionality to add, update, and delete users.
    - Functionality to retrieve user information by UserID.
    - User information includes UserID, UserName, UserEmail, UserPassword, UserContact, Role.

2. **Resource Management:**
    - Functionality to add, update, and delete resources.
    - Functionality to retrieve resource information by ResourceID.
    - Resource information includes ResourceID, ResourceName, ResourceDescription, ResourceStatus, MaintenanceStatus.

3. **Booking Management:**
    - Functionality to create, update, and delete bookings.
    - Functionality to retrieve booking information by BookingID.
    - Booking information includes BookingID, UserID, ResourceID, BookingDate, BookingStartTime, BookingEndTime.
    - Booking will require checking resource availability and user validation.

4. **Maintenance Management:**
    - Functionality to log maintenance activities, update, and delete maintenance records.
    - Functionality to retrieve maintenance information by MaintenanceID.
    - Maintenance information includes MaintenanceID, ResourceID, UserID, MaintenanceDate, MaintenanceDetails.

5. **Utilization Report Management:**
    - Functionality to generate utilization reports.
    - Functionality to retrieve utilization report by ReportID.
    - Utilization report information includes ReportID, ResourceID, UserID, GeneratedDate, UtilizationData.


- **Security and Authentication:**
    - Different roles have different privileges (e.g., an administrator might be able to add or delete users, 
  while a standard user can only make bookings).

- **Exception handling and Validation:**
    - Proper validation checks for each operation (e.g., check for duplicate users, validate dates and times, etc.).
    - Proper exception handling for each operation (e.g., unable to connect to database, null value where one is not allowed, etc.).

- **Search and filter functionality:**
    - Users may need to search for resources, bookings, maintenance records, and reports based on various criteria.

- **API Documentation:**
    - Providing clear API documentation can make it easier for others to understand and use ResourceLab

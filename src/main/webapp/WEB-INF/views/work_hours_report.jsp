<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Time Tracker</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
</head>
<body class="bg-light">
    <nav class="navbar navbar-dark bg-primary">
        <div class="container-fluid">
            <span class="navbar-brand mb-0 h1">
                Times Tracker
            </span>
            <div class="d-flex align-items-center text-white">
                <div class="me-3 text-end">
                    <small class="d-block">Logged in as</small>
                    <strong>${username}</strong>
                </div>
                <form action="${pageContext.request.contextPath}/logout" method="post" class="d-inline">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-outline-light btn-sm">
                        Logout
                    </button>
                </form>
            </div>
        </div>
    </nav>
    <div class="container my-4">
        <div class="card shadow-sm mb-4">
            <div class="card-header bg-primary text-white">
                Filter Options
            </div>
            <div class="card-body">
                <form action="${pageContext.request.contextPath}/report" method="get" class="row g-3">
                    <div class="col-md-4">
                        <label for="startDate" class="form-label">Start Date</label>
                        <input type="datetime-local" class="form-control" id="startDate" name="startDate" value="${startDate}">
                    </div>
                    
                    <div class="col-md-4">
                        <label for="endDate" class="form-label">End Date</label>
                        <input type="datetime-local" class="form-control" id="endDate" name="endDate" value="${endDate}">
                    </div>
                    
                    <div class="col-md-4 d-flex align-items-end gap-2">
                        <button type="submit" class="btn btn-primary">
                            Filter
                        </button>
                        <a href="${pageContext.request.contextPath}/report" class="btn btn-secondary">
                            Clear
                        </a>
                    </div>
                </form>
            </div>
        </div>
        
        <c:if test="${not empty reportData}">
            <div class="card shadow-sm mb-3">
                <div class="card-body">
                    <h6 class="text-muted mb-0">
                        Total Records: <strong>${reportData.size()}</strong>
                    </h6>
                </div>
            </div>
        </c:if>
        
        <div class="card shadow-sm">
            <div class="card-body p-0">
                <div class="table-responsive">
                    <table class="table table-hover table-striped mb-0">
                        <thead class="table-primary">
                            <tr>
                                <th>Employee Code</th>
                                <th>Employee Name</th>
                                <th>Project Name</th>
                                <th>Total Hours</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:choose>
                                <c:when test="${not empty reportData}">
                                    <c:forEach var="record" items="${reportData}">
                                        <tr>
                                            <td>${record.employeeCode}</td>
                                            <td>${record.employeeName}</td>
                                            <td>${record.projectName}</td>
                                            <td><strong><fmt:formatNumber value="${record.hoursWorked}" maxFractionDigits="2" 
                                            minFractionDigits="2"/></strong> hrs</td>
                                        </tr>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <tr>
                                        <td colspan="4" class="text-center py-5 text-muted">
                                            <p class="mt-2">No time records found</p>
                                        </td>
                                    </tr>
                                </c:otherwise>
                            </c:choose>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

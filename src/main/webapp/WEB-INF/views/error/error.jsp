<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error - Time Tracker</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
</head>
<body class="bg-light">
    <div class="container">
        <div class="row justify-content-center align-items-center min-vh-100">
            <div class="col-md-6 col-lg-5">
                <div class="card shadow text-center">
                    <div class="card-body p-5">
                        <h1 class="display-1 fw-bold text-danger">${status != null ? status : '500'}</h1>
                        <h4 class="mb-3">Oops! Something went wrong</h4>
                        <div class="alert alert-danger text-start" role="alert">
                            <strong>Error Message:</strong><br>
                            <span class="text-muted">${message != null ? message : 'An unexpected error occurred. Please try again later.'}</span>
                        </div>
                        <div class="d-grid gap-2">
                            <a href="${pageContext.request.contextPath}/report" class="btn btn-primary btn-lg">
                                Back to Reports
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

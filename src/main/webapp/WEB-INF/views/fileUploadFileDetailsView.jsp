<%--
  Created by IntelliJ IDEA.
  User: liena
  Date: 24/02/2020
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
- isELIgnored : JSP Expression Language (EL) is useful and is evaluated in JSP pages by default since Servlet 2.4. However, sometimes we would not want to evaluate EL, e.g. keep everything in the pattern ${..} looks as it is. In JSP, it’s possible to deactivate EL evaluation for a single JSP page for a group of JSPs.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>

<html>
<h2>${fileName} uploaded successfully refer to console for out put</h2>
</html>

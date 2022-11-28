<%--<%@ include file="/WEB-INF/jsp/header.jsp"%>--%>

<%--&lt;%&ndash;<c:url var="home" value="/aaa" />&ndash;%&gt;--%>
<%--&lt;%&ndash;<c:url var="app" value="/app.js" />&ndash;%&gt;--%>

<%--<div id="myApp">--%>
<%--    <div class="container">--%>
<%--        <h1>My application</h1>--%>
<%--        <p>Hello.</p>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<%@ include file="/WEB-INF/jsp/footer.jsp"%>--%>


<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="home" value="/aaa" />
<c:url var="app" value="/app.js" />

<c:url var="show-movie" value="/api/cvs/" />

<div id="myApp">
    <div class="container">
        <h1>Gestion CV</h1>
    </div>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#" v-on:click="getCvs">List of movies</a>
    </nav>
</div>
<script src="${app}" type="module"></script>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
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

    <table class="table">
        <tr>
            <th>FirstName</th>
            <th>LastName</th>
        </tr>
        <tr v-for="cv in cvs">
            <td>{{cv.person.firstName}}</td>
            <td>{{cv.person.lastName}}</td>

            <%--Actions--%>
            <td><button class="btn btn-primary btn-sm"
                        v-on:click="showCv(cv.person.id)">Show Cv</button></td>

            <td><button class="btn btn-success btn-sm"
                        v-on:click="editMovie(movie)">Edit</button></td>

            <td><button class="btn btn-danger btn-sm"
                        v-on:click="deleteMovie(movie.id)">Delete</button></td>
        </tr>
    </table>

    <table v-if="(activities != null)" class="table">
        <tr>
            <th>id</th>
            <th>year</th>
            <th>nature</th>
        </tr>

        <tr v-for="activity in activities">
            <td>{{activity.id}}</td>
            <td>{{activity.year}}</td>
            <td>{{activity.nature}}</td>
        </tr>

    </table>

</div>
<script src="${app}" type="module"></script>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
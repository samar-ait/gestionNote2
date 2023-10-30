<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Vector" %>
<%@ page import="mod.sco.Note" %>
<%@ page import="form.beans.NoteForm" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Notes</title>
    
</head>
<body>
    <form action="ControleurServlet" method="post">
        Num Inscription : <input type="text" name="num_Ins">
        <input type="submit" value="OK"> 
    </form>

    <table border="1">
        <tr>
            <th>Matiere</th>
            <th>Note</th>
        </tr>
        <%
        NoteForm nf = (NoteForm) session.getAttribute("nf");
        	if(nf != null){
            Vector<Note> notes = nf.getLesNotes();
            float totalSum = 0.0f;
            int totalCount = 0;
            for (Note note : notes) {
                totalSum += note.getNote();
                totalCount++;
        %>
            <tr>
                <td><%= note.getMatiere() %></td>
                <td><%= note.getNote() %></td>
            </tr>
        <%
            }
            float overallAverage = (totalCount > 0) ? totalSum / totalCount : 0.0f;
            %>
            <tr>
                <td colspan="1" style="background-color: #007bff ;color:white"><strong>Moyenne:</strong></td>
                <td style="background-color: #f0f0f0"><%= overallAverage %></td>
            </tr>
            <%
        	} else {
        		%>
        	<tr>
                <td colspan="2">No data available.</td>
            </tr>
        		<%
        	}
        %>
    </table>
</body>
</html>

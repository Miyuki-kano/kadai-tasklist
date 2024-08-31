package controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// DTOクラスとあわせるからmodels.Taskとなる
import models.Task;
import utils.DBUtil;


/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();
//      List<DTO class> 変数名(今回はテーブル名と合わせたけどなんでもいい)、("getAllTask", Task.class)ここはDTOクラス名
        List<Task> tasks = em.createNamedQuery("getAllTask", Task.class).getResultList();
//      後ろの方のmessagesは上の行の変数と同じにしているだけ
        response.getWriter().append(Integer.valueOf(tasks.size()).toString());

        em.close();
    }

}

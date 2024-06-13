package org.example.exercice6.controller;

public class UserServlet {
    private UserService us;
    private User u;

    @Override
    public void init() {
        us = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("logForm.jsp").forward(req,resp);
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getServletPath();

        try {
            switch (action){
                case "/register":
                    register(req, resp);
                    break;
                case "/login":
                    login(req, resp);
                    break;
                default:
                    showLoginForm(req, resp);
                    break;
            }
        } catch (Exception ex){
            throw new ServletException();
        }

    }

    public void showLoginForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        RequestDispatcher dispatcher = req.getRequestDispatcher("logForm.jsp");
        dispatcher.forward(req, resp);
    }

    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String userName = req.getParameter("username");
        String password = req.getParameter("password");

        u = new User(userName, password);
        //resp.sendRedirect("products");
        if (us.create(u)){
            HttpSession session = req.getSession();
            session.setAttribute("estCo", true);
            resp.sendRedirect("products");
        } else {
            resp.sendRedirect("user");

        }
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        HttpSession session = req.getSession();

        boolean estCo = (session.getAttribute("est co")!= null) ? (boolean) session.getAttribute(" est co") :false;
        if (!estCo){
            resp.sendRedirect("list");
        } else {
            resp.sendRedirect("/user/register");
        }
    }
}

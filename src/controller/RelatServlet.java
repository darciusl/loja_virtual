package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.RelatorioUtil;

@WebServlet("/RelatServlet")
public class RelatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Map<String, Object> parametros = new HashMap<String, Object>();

		String nomeRelat = request.getParameter("nomeRelat");
        
		if (nomeRelat.equalsIgnoreCase("produto")) {
			BigDecimal aux1 = new BigDecimal(request.getParameter("valorMin"));
			parametros.put("valorMin", aux1);
			BigDecimal aux2 = new BigDecimal(request.getParameter("valorMax"));
			parametros.put("valorMax", aux2);
		}


		String arquivoJasper = getServletContext().getRealPath(
				"/WEB-INF/relatorios/" + nomeRelat + ".jasper");

		byte[] bytes = RelatorioUtil.criarRelatorio(arquivoJasper, parametros);

		if (bytes != null && bytes.length > 0) {
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		}
	}
}

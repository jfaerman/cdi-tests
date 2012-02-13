package jfaerman;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/testEvents")
public class TestEventsServlet extends HttpServlet {
	@Inject BeanManager beanManager;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/plain");
		PrintWriter writer = resp.getWriter();
		
		StringEvent event = new StringEvent("* Can i haz inheritance? *");
		List<AbstractEvent> events = new ArrayList<AbstractEvent>();
		events.add(event);
		
		fireOneEvent(event);
		fireAllEvents(events);
	}

	private void fireAllEvents(List<AbstractEvent> events) {
		for(AbstractEvent evt:events){
			beanManager.fireEvent(evt, new Annotation[]{});
		}
	}

	private void fireOneEvent(StringEvent event) {
		beanManager.fireEvent(event, new Annotation[]{});
	}
	
	public void onStringEvent(@Observes StringEvent event){
		System.out.println(System.currentTimeMillis()+" " +event.getValue());
	}
	
}

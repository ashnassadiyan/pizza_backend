package pizza.pizza.hub.requests;

public class FeedbackRequest {
    private  String comment;
    private  String orderId ;

    public FeedbackRequest(String comment,String orderId){
        this.comment=comment;
        this.orderId=orderId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}

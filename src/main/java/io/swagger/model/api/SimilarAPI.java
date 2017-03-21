package io.swagger.model.api;

public class SimilarAPI {

		String type;
		double score;
		ToAPI to;
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public double getScore() {
			return score;
		}
		public void setScore(double score) {
			this.score = score;
		}
		public ToAPI getTo() {
			return to;
		}
		public void setTo(ToAPI to) {
			this.to = to;
		}
		
		
		
}


/*
{
    "type": "similarity",
    "score": 0.7555685748092372,
    "to": {
      "id": "mL_DGrnuX2sML",
      "uri": "http://librairy.org/items/mL_DGrnuX2sML",
      "name": "Managing Product Management: Empowering Your Organization to Produce Competitive Products and Brands"
    }
  },
*/
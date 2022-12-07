import axios from "axios";

const SPRING_URL = "http://localhost:8899/api/article";

//중복되는 작업을 위해 class로 모듈화
// axios 작업만 분리 : 클래스로 작업
// Spring url :상수로 처리
// Restful : get,post,put(수정),delete(삭제)
class ArticleService {
  // 메소드명(파라미터){
  //   return 작업코드
  // }
  //전체 가져오기
  getArticles() {
    return axios.get(SPRING_URL);
  }
  //저장하기
  createArticle(article) {
    return axios.post(SPRING_URL, article);
  }

  //하나만 가져오기
  getArticleById() {
    return axios.get(SPRING_URL);
  }

  //수정하기
  updateArticle() {
    return axios.put(SPRING_URL);
  }

  //삭제하기
  deleteArticle() {
    return axios.delete(SPRING_URL);
  }
}

export default new ArticleService();
//파일 외부에서 사용하게 하려면 export : export,export default 함수명
//class 형식은 다르게함.
//export default new 파일이름()

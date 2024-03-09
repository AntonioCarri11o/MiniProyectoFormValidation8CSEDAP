import axios from 'axios';

const URL_API = 'http://localhost:8080/api/form/';

export const postForm = async (form) => {
    const response = await axios.post(URL_API, form);
    return response.data;
  };
export const list = async () => {
  const response = await axios.get(URL_API);
  return response.data;
}
  export default {
    postForm,
    list,
  };
  
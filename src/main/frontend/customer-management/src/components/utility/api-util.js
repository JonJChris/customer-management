

export const putRequestAndThenCallBack = async (url, requestBody, callbackFunc) => {
    try {
      const resp = await fetch(url, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(requestBody)
      });
      if (!resp.ok) {
        const errResp = await resp.json();
        throw new Error("[POST] Error while fetching URL  " + JSON.stringify(errResp) )
      }
      const data = await resp.json();
      callbackFunc(data);
    } catch (error) {
      callbackFunc(null);
    }
  }


export const postRequestAndThenCallBack = async (url, requestBody, callbackFunc) => {
  try {
    const resp = await fetch(url, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(requestBody)
    });
    if (!resp.ok) {
      const errResp = await resp.json();
      throw new Error("[POST] Error while fetching URL  " + JSON.stringify(errResp) )
    }
    const data = await resp.json();
    callbackFunc(data);
  } catch (error) {
    callbackFunc(null);
}
}


  export const getRequestAndThenCallBack = async (url, callbackFunc) => {
    try {
      const resp = await fetch(url, {
        method: 'GET'
      });
      if (!resp.ok) {
        const errResp = await resp.json();
        throw new Error("[GET] Error while fetching URL  " + JSON.stringify(errResp) )
      }
      const data = await resp.json();
      callbackFunc(data);
    } catch (error) {
      callbackFunc(null);
    }
  }
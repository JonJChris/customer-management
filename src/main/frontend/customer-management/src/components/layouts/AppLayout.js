import React, { useEffect } from 'react'
import { Outlet, useNavigate } from 'react-router-dom'
import NavBarCustom from '../contents/common/NavBarCustom'
import { useDispatch, useSelector } from 'react-redux';
import { actions } from './../../store/master-data'
import { putRequestAndThenCallBack, getRequestAndThenCallBack } from './../utility/api-util'
import {API_CALL_BASE_URL} from './../utility/constants'
const AppLayout = (props) => {
    const dispatch = useDispatch();
    const masterData = useSelector(state => state.masterDataSlice);
    const userData = useSelector(state => state.UserStoreSlice);
    const navigate = useNavigate();
    const updateMasterDataInStore = (masterData) => {
        dispatch(actions.refreshMasterData(masterData));
    }

    useEffect(() => {
        if (!masterData.masterDataExists) {
            getRequestAndThenCallBack(`${API_CALL_BASE_URL}/masterData/fetchAll`, updateMasterDataInStore);
        }
        if(userData.userDetails.username === ''){
            navigate('/login')
        }
    });

    return (
        <div>
            <NavBarCustom />

            <Outlet />
        </div>
    )
}

export default AppLayout
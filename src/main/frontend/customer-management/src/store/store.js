import {combineReducers, configureStore} from '@reduxjs/toolkit'
import masterDataSlice from './master-data';
import UIFieldStoreSlice from './ui-field-store'
import UserStoreSlice from './user-store'

import storage from 'redux-persist/lib/storage';
import { persistReducer, persistStore } from 'redux-persist';
import thunk from 'redux-thunk';

const persistConfig = {
    key: 'root',
    storage,
  }

  const reducers = combineReducers({
    masterDataSlice: masterDataSlice.reducer,
    UIFieldStoreSlice: UIFieldStoreSlice.reducer,
    UserStoreSlice: UserStoreSlice.reducer
   });
   

const persistedReducer = persistReducer(persistConfig, reducers)

export const store = configureStore(
    {
        // reducer:{
        //     masterDataSlice: masterDataSlice.reducer,
        //     UIFieldStoreSlice: UIFieldStoreSlice.reducer,
        //     UserStoreSlice: UserStoreSlice.reducer

        // },
        reducer:persistedReducer,
        middleware: [thunk]
    }
);

// export default store;
export const persistor = persistStore(store)
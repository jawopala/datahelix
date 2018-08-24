import * as React from "react";
import {connect} from "react-redux";
import {Action, Dispatch} from "redux";
import {ActionType} from "../redux/actions/ActionType";

interface IClickableProps
{
	onClick?: (...args: any[]) => void
}

/** Returns a container component wrapping a clickable component, such that clicking that component yields a specified Action */
export function dispatchesActionOnClick<T extends IClickableProps>(
	actionFunc: () => Action,
	subElement: React.ComponentType<T>)
	: React.ComponentType<T>
{
	return connect<{}, {}, T, T>(
		undefined,
		(dispatch: Dispatch) => (<T><any>{
			onClick: () => { dispatch(actionFunc()) }
		}))
	(subElement);
}

/** Returns a container component wrapping a clickable component, such that clicking that component yields a specified Action */
export function dispatchesBasicActionOnClick<T extends IClickableProps>(
	actionType: ActionType<{}, any>,
	subElement: React.ComponentType<T>)
	: React.ComponentType<T>
{
	return dispatchesActionOnClick(
		() => actionType.create({}),
		subElement);
}
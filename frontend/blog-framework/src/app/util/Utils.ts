import * as _ from 'lodash';

const trimObject = (obj: any) => {
    _.each(obj, (value: any, key: any) => {
        if (value !== undefined) {
            if (_.isObject(value)) {
                obj[key] = trimObject(value);
            } else {
                obj[key] = typeof value === 'string' ? value.trim().replace(/\s+/g, ' ') : value;
            }
        }
    });
    return obj;
};

export const isEqual = (value: any, other: any): boolean => {
    return _.isEqual(trimObject(value), trimObject(other));
};

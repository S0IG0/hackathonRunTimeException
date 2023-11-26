/* eslint-disable */
/* tslint:disable */

/*
 * ---------------------------------------------------------------
 * ## THIS FILE WAS GENERATED VIA SWAGGER-TYPESCRIPT-API        ##
 * ##                                                           ##
 * ## AUTHOR: acacode                                           ##
 * ## SOURCE: https://github.com/acacode/swagger-typescript-api ##
 * ---------------------------------------------------------------
 */

/** Сведения об ошибке */
export interface ApiError {
    /**
     * Список стектрейсов или описания ошибок
     * @example [{},{}]
     */
    errors?: string[];
    /**
     * Сообщение об ошибке
     * @example "Only pending events can be moderated by admin"
     */
    message?: string;
    /**
     * Общее описание причины ошибки
     * @example "For the requested operation the conditions are not met."
     */
    reason?: string;
    /**
     * Код статуса HTTP-ответа
     * @example "FORBIDDEN"
     */
    status?:
        | "100 CONTINUE"
        | "101 SWITCHING_PROTOCOLS"
        | "102 PROCESSING"
        | "103 CHECKPOINT"
        | "200 OK"
        | "201 CREATED"
        | "202 ACCEPTED"
        | "203 NON_AUTHORITATIVE_INFORMATION"
        | "204 NO_CONTENT"
        | "205 RESET_CONTENT"
        | "206 PARTIAL_CONTENT"
        | "207 MULTI_STATUS"
        | "208 ALREADY_REPORTED"
        | "226 IM_USED"
        | "300 MULTIPLE_CHOICES"
        | "301 MOVED_PERMANENTLY"
        | "302 FOUND"
        | "302 MOVED_TEMPORARILY"
        | "303 SEE_OTHER"
        | "304 NOT_MODIFIED"
        | "305 USE_PROXY"
        | "307 TEMPORARY_REDIRECT"
        | "308 PERMANENT_REDIRECT"
        | "400 BAD_REQUEST"
        | "401 UNAUTHORIZED"
        | "402 PAYMENT_REQUIRED"
        | "403 FORBIDDEN"
        | "404 NOT_FOUND"
        | "405 METHOD_NOT_ALLOWED"
        | "406 NOT_ACCEPTABLE"
        | "407 PROXY_AUTHENTICATION_REQUIRED"
        | "408 REQUEST_TIMEOUT"
        | "409 CONFLICT"
        | "410 GONE"
        | "411 LENGTH_REQUIRED"
        | "412 PRECONDITION_FAILED"
        | "413 PAYLOAD_TOO_LARGE"
        | "413 REQUEST_ENTITY_TOO_LARGE"
        | "414 URI_TOO_LONG"
        | "414 REQUEST_URI_TOO_LONG"
        | "415 UNSUPPORTED_MEDIA_TYPE"
        | "416 REQUESTED_RANGE_NOT_SATISFIABLE"
        | "417 EXPECTATION_FAILED"
        | "418 I_AM_A_TEAPOT"
        | "419 INSUFFICIENT_SPACE_ON_RESOURCE"
        | "420 METHOD_FAILURE"
        | "421 DESTINATION_LOCKED"
        | "422 UNPROCESSABLE_ENTITY"
        | "423 LOCKED"
        | "424 FAILED_DEPENDENCY"
        | "425 TOO_EARLY"
        | "426 UPGRADE_REQUIRED"
        | "428 PRECONDITION_REQUIRED"
        | "429 TOO_MANY_REQUESTS"
        | "431 REQUEST_HEADER_FIELDS_TOO_LARGE"
        | "451 UNAVAILABLE_FOR_LEGAL_REASONS"
        | "500 INTERNAL_SERVER_ERROR"
        | "501 NOT_IMPLEMENTED"
        | "502 BAD_GATEWAY"
        | "503 SERVICE_UNAVAILABLE"
        | "504 GATEWAY_TIMEOUT"
        | "505 HTTP_VERSION_NOT_SUPPORTED"
        | "506 VARIANT_ALSO_NEGOTIATES"
        | "507 INSUFFICIENT_STORAGE"
        | "508 LOOP_DETECTED"
        | "509 BANDWIDTH_LIMIT_EXCEEDED"
        | "510 NOT_EXTENDED"
        | "511 NETWORK_AUTHENTICATION_REQUIRED";
    /**
     * Дата и время когда произошла ошибка (в формате "yyyy-MM-dd HH:mm:ss")
     * @example "2022-06-09 06:27:23"
     */
    timestamp?: string;
}

/**
 * Список категорий новостей
 * @example "Вода"
 */
export enum Category {
    Water = "Вода",
    Light = "Свет",
    Gas = "Газ",
    Heating = "Отопление",
    Street = "Улица",
    Other = "Другое",
}

/** Новость */
export interface NewsDto {
    /**
     * Идентификатор
     * @format int64
     * @example 1
     */
    id?: number;
    /**
     * Название новости
     * @example "Лед появился"
     */
    title?: string;
    author?: OrginizationShortDto;
    /** Адрес, широта и долгота локации */
    location?: Location;
    /** Дата и время. Дата и время указываются в формате "yyyy-MM-dd HH:mm:ss" */
    date?: Date;
    /** Картинка файлом */
    picture?: Picture;
    /**
     * Текст новости
     * @example "Скоро уберем"
     */
    text?: string;
    /** Опрос жителей */
    Survey?: SurveyDto;
    /** Список состояний жизненного цикла новости/события */
    status?: Status;
    /** Список категорий новостей */
    category?: Category;
    /**
     * Список комментариев к новости
     * @example [{"id":1,"text":"Чибипеля","commentDate":"2024-12-31 15:10:05","commentAuthor":{"id":3,"name":"Даня","surname":"Красавчик"}},{"id":2,"text":"Чибипеля 2","commentDate":"2024-12-31 15:10:05","commentAuthor":{"id":3,"name":"Даня","surname":"Красавчик"}}]
     */
    comments?: any[];
}

/** Новость */
export interface NewNewsDto {
    /**
     * Название новости
     * @example "Лед появился"
     */
    title?: string;
    /** Адрес, широта и долгота локации */
    location?: Location;
    /** Дата и время. Дата и время указываются в формате "yyyy-MM-dd HH:mm:ss" */
    date?: Date;
    /** Картинка файлом */
    picture?: Picture;
    /**
     * Текст новости
     * @example "Скоро уберем"
     */
    text?: string;
    /** Новый опрос */
    Survey?: NewSurveyDto;
    /** Список категорий новостей */
    category?: Category;
}

/** Новый комментарий */
export interface NewCommentDto {
    /**
     * Текст комментария
     * @example "Ремонт дороги"
     */
    text?: string;
}

/** Комментарий */
export interface CommentDto {
    /**
     * Идентификатор
     * @format int64
     * @example 1
     */
    id?: number;
    /**
     * Текст комментария
     * @example "Ремонт дороги"
     */
    text?: string;
    /** Дата и время. Дата и время указываются в формате "yyyy-MM-dd HH:mm:ss" */
    commentDate?: Date;
    /** Пользователь (краткая информация) */
    commentAuthor?: UserShortDto;
}

/** Опрос жителей */
export interface SurveyDto {
    /**
     * Идентификатор
     * @format int64
     * @example 1
     */
    id?: number;
    /**
     * Описание опроса
     * @example "Стоит ли покупать подержанный гараж?"
     */
    description?: string;
    /**
     * Описание опроса
     * @example [{"id":1,"text":"Да я люблю гаражи хочу еще один","votes":100},{"id":2,"text":"Нет я люблю только свой гараж","votes":66}]
     */
    options?: any[];
}

/** Новый опрос */
export interface NewSurveyDto {
    /**
     * Список ответов к опросу
     * @example ["Круто","Плохо"]
     */
    options?: any[];
    /**
     * Заголовок опроса
     * @example "Голосование за дизайн парка"
     */
    title?: string;
    /**
     * Описание опроса
     * @example "Выберите дизайн нового парка"
     */
    description?: string;
}

/** Опрос жителей */
export interface OptionDto {
    /**
     * Идентификатор опции
     * @format int64
     * @example 1
     */
    id?: number;
    /**
     * Текст опции
     * @example "Да я люблю гаражи хочу еще один"
     */
    text?: string;
    /**
     * Количество голосов
     * @format int64
     * @example "100"
     */
    votes?: number;
}

export interface OrginizationShortDto {
    /**
     * Идентификатор
     * @format int64
     * @example 7771272
     */
    id?: number;
    /**
     * Название компании
     * @example "ЖЭК"
     */
    name?: string;
}

/** Картинка файлом */
export type Picture = any;

/** Подборка событий */
export interface CompilationDto {
    /**
     * Список событий входящих в подборку
     * @uniqueItems true
     * @example [{"annotation":"Эксклюзивность нашего шоу гарантирует привлечение максимальной зрительской аудитории","category":{"id":1,"name":"Концерты"},"confirmedRequests":5,"eventDate":"2024-03-10 14:30:00","id":1,"initiator":{"id":3,"name":"Фёдоров Матвей"},"paid":true,"title":"Знаменитое шоу 'Летающая кукуруза'","views":999},{"annotation":"За почти три десятилетия группа 'Java Core' закрепились на сцене как группа, объединяющая поколения.","category":{"id":1,"name":"Концерты"},"confirmedRequests":555,"eventDate":"2025-09-13 21:00:00","id":1,"initiator":{"id":3,"name":"Паша Петров"},"paid":true,"title":"Концерт рок-группы 'Java Core'","views":991}]
     */
    events?: any[];
    /**
     * Идентификатор
     * @format int64
     * @example 1
     */
    id: number;
    /**
     * Закреплена ли подборка на главной странице сайта
     * @example true
     */
    pinned: boolean;
    /**
     * Заголовок подборки
     * @example "Летние концерты"
     */
    title: string;
}

/** Адрес, широта и долгота локации */
export interface Location {
    /**
     * Адрес локации
     * @example "Ул. Колотушкина, д. Пушкина"
     */
    address?: string;
    /**
     * Широта
     * @format float
     * @example 55.754167
     */
    lat?: number;
    /**
     * Долгота
     * @format float
     * @example 37.62
     */
    lon?: number;
}

/**
 * Дата и время. Дата и время указываются в формате "yyyy-MM-dd HH:mm:ss"
 * @example "2024-12-31 15:10:05"
 */
export type Date = string;

/** Пользователь (житель) */
export interface NewUserDto {
    /**
     * Почтовый адрес
     * @minLength 6
     * @maxLength 254
     * @example "petrov.i@mail.ru"
     */
    email?: string;
    /**
     * Адрес проживания
     * @minLength 10
     * @example "ул. Пушкина, д.3"
     */
    address?: string;
    /**
     * Имя
     * @minLength 1
     * @maxLength 100
     * @example "Даниил"
     */
    name?: string;
    /**
     * Фамилия
     * @minLength 1
     * @maxLength 100
     * @example "Чибиток"
     */
    surname?: string;
    /**
     * Фамилия
     * @minLength 1
     * @maxLength 100
     * @example "Чибиток"
     */
    password?: string;
}

/** Пользователь (житель) */
export interface UserDto {
    /**
     * Почтовый адрес
     * @example "petrov.i@mail.ru"
     */
    email?: string;
    /**
     * Идентификатор
     * @format int64
     * @example 1
     */
    id?: number;
    /**
     * Имя
     * @example "Даниил"
     */
    name?: string;
    /**
     * Фамилия
     * @example "Чибиток"
     */
    surname?: string;
}

export interface EventDto {
    /**
     * Идентификатор
     * @format int64
     * @example 1
     */
    id?: number;
    /**
     * Название мероприятия
     * @example "Ремонт дороги"
     */
    title?: string;
    /**
     * Описание мероприятия
     * @example "Ремонт продлится с 01.01.2023 до 02.01.2023"
     */
    text?: string;
    /** Список состояний жизненного цикла новости/события */
    status?: Status;
    /** Список категорий новостей */
    category?: Category;
    author?: OrginizationShortDto;
    /** Адрес, широта и долгота локации */
    location?: Location;
    /** Дата и время. Дата и время указываются в формате "yyyy-MM-dd HH:mm:ss" */
    date?: Date;
    /** Картинка файлом */
    picture?: Picture;
    /**
     * Список комментариев к новости
     * @example [{"id":1,"text":"Чибипеля","commentDate":"2024-12-31 15:10:05","commentAuthor":{"id":3,"name":"Даня","surname":"Красавчик"}},{"id":2,"text":"Чибипеля 2","commentDate":"2024-12-31 15:10:05","commentAuthor":{"id":3,"name":"Даня","surname":"Красавчик"}}]
     */
    comments?: any[];
}

export interface NewEventDto {
    /**
     * Название мероприятия
     * @example "Ремонт дороги"
     */
    title?: string;
    /**
     * Описание мероприятия
     * @example "Ремонт продлится с 01.01.2023 до 02.01.2023"
     */
    text?: string;
    /** Список категорий новостей */
    category?: Category;
    /** Адрес, широта и долгота локации */
    location?: Location;
    /** Дата и время. Дата и время указываются в формате "yyyy-MM-dd HH:mm:ss" */
    date?: Date;
    /** Картинка файлом */
    picture?: Picture;
}

/** Запрос от жителя к администрации */
export interface RequestDto {
    /**
     * Идентификатор
     * @format int64
     * @example 1
     */
    id?: number;
    /**
     * Название запроса
     * @example "Почините водопровод"
     */
    title?: string;
    /**
     * Описание запроса
     * @example "Почините водопровод по адресу ул. Пушкина, д.3"
     */
    text?: string;
    /** Пользователь (житель) */
    initiator?: UserDto;
    receiver?: any;
    /**
     * Дата создания запроса
     * @format date-time
     * @example "2023-11-24T12:00:00Z"
     */
    request_date?: string;
    /**
     * Статус выполнения запроса
     * @example "В обработке"
     */
    status?: string;
    /**
     * Статус выполнения запроса
     * @example [{"id":1,"text":"Выслали ремонтников, скоро будут на месте","picture":"string","rating":1},{"id":2,"text":"Неисправность устранена","picture":"string","rating":5}]
     */
    responses?: any[];
    /**
     * Список комментариев к новости
     * @example [{"id":1,"text":"Чибипеля","commentDate":"2024-12-31 15:10:05","commentAuthor":{"id":3,"name":"Даня","surname":"Красавчик"}},{"id":2,"text":"Чибипеля 2","commentDate":"2024-12-31 15:10:05","commentAuthor":{"id":3,"name":"Даня","surname":"Красавчик"}}]
     */
    comments?: any[];
}

/** Новое обращение к администрации от жителя */
export interface NewRequestDto {
    /**
     * Название запроса
     * @example "Почините водопровод"
     */
    title?: string;
    /**
     * Описание запроса
     * @example "Почините водопровод по адресу ул. Пушкина, д.3"
     */
    text?: string;
    /** Картинка файлом */
    picture?: Picture;
}

/** Новый ответ организации на обращение */
export interface NewResponseDto {
    /**
     * Содержание ответа на запрос
     * @example "Неисправность устранена"
     */
    text?: string;
    /** Картинка файлом */
    picture?: Picture;
}

/** Новый ответ организации на обращение */
export interface ResponseDto {
    /**
     * Идентификатор
     * @format int64
     * @example 1
     */
    id?: number;
    /**
     * Содержание ответа на запрос
     * @example "Неисправность устранена"
     */
    text?: string;
    /** Картинка файлом */
    picture?: Picture;
    /**
     * Оценка ответа от пользователей
     * @format float
     * @example 1
     */
    rating?: number;
}

/**
 * Список состояний жизненного цикла новости/события
 * @example "PUBLISHED"
 */
export enum Status {
    WaitingForModeration = "Ожидание модерации",
    Published = "Опубликовано",
    DeniedPublication = "Отказано в публикации",
}

/**
 * Список состояний запроса
 * @example "Выполнено"
 */
export enum RequestStatus {
    Done = "Выполнено",
    InProcess = "В процессе",
    InProcessing = "В обработке",
    Denied = "Отказано",
}

/** Пользователь (краткая информация) */
export interface UserShortDto {
    /**
     * Идентификатор
     * @format int64
     * @example 3
     */
    id?: number;
    /**
     * Имя
     * @example "Даня"
     */
    name?: string;
    /**
     * Фамилия
     * @example "Красавчик"
     */
    surname?: string;
}

/** Новая организация (создается администратором) */
export interface NewOrginizationDto {
    /**
     * ИНН на сервере преобразовываться в id
     * @example "123456789012"
     */
    inn?: number;
    /**
     * Почта
     * @example "exaple@mail.ru"
     */
    email?: string;
    /**
     * Название
     * @example "Сутенерская ОЭ по району Отрадное"
     */
    name?: string;
    /**
     * Адрес
     * @example "проезд Якушкина, 4, Москва, 127273"
     */
    address?: string;
    /**
     * Пароль
     * @example "password"
     */
    password?: string;
}

export type QueryParamsType = Record<string | number, any>;
export type ResponseFormat = keyof Omit<Body, "body" | "bodyUsed">;

export interface FullRequestParams extends Omit<RequestInit, "body"> {
    /** set parameter to `true` for call `securityWorker` for this request */
    secure?: boolean;
    /** request path */
    path: string;
    /** content type of request body */
    type?: ContentType;
    /** query params */
    query?: QueryParamsType;
    /** format of response (i.e. response.json() -> format: "json") */
    format?: ResponseFormat;
    /** request body */
    body?: unknown;
    /** base url */
    baseUrl?: string;
    /** request cancellation token */
    cancelToken?: CancelToken;
}

export type RequestParams = Omit<FullRequestParams, "body" | "method" | "query" | "path">;

export interface ApiConfig<SecurityDataType = unknown> {
    baseUrl?: string;
    baseApiParams?: Omit<RequestParams, "baseUrl" | "cancelToken" | "signal">;
    securityWorker?: (securityData: SecurityDataType | null) => Promise<RequestParams | void> | RequestParams | void;
    customFetch?: typeof fetch;
}

export interface HttpResponse<D extends unknown, E extends unknown = unknown> extends Response {
    data: D;
    error: E;
}

type CancelToken = Symbol | string | number;

export enum ContentType {
    Json = "application/json",
    FormData = "multipart/form-data",
    UrlEncoded = "application/x-www-form-urlencoded",
    Text = "text/plain",
}

export class HttpClient<SecurityDataType = unknown> {
    public baseUrl: string = "";
    private securityData: SecurityDataType | null = null;
    private securityWorker?: ApiConfig<SecurityDataType>["securityWorker"];
    private abortControllers = new Map<CancelToken, AbortController>();
    private customFetch = (...fetchParams: Parameters<typeof fetch>) => fetch(...fetchParams);

    private baseApiParams: RequestParams = {
        credentials: "same-origin",
        headers: {},
        redirect: "follow",
        referrerPolicy: "no-referrer",
    };

    constructor(apiConfig: ApiConfig<SecurityDataType> = {}) {
        Object.assign(this, apiConfig);
    }

    public setSecurityData = (data: SecurityDataType | null) => {
        this.securityData = data;
    };

    protected encodeQueryParam(key: string, value: any) {
        const encodedKey = encodeURIComponent(key);
        return `${encodedKey}=${encodeURIComponent(typeof value === "number" ? value : `${value}`)}`;
    }

    protected addQueryParam(query: QueryParamsType, key: string) {
        return this.encodeQueryParam(key, query[key]);
    }

    protected addArrayQueryParam(query: QueryParamsType, key: string) {
        const value = query[key];
        return value.map((v: any) => this.encodeQueryParam(key, v)).join("&");
    }

    protected toQueryString(rawQuery?: QueryParamsType): string {
        const query = rawQuery || {};
        const keys = Object.keys(query).filter((key) => "undefined" !== typeof query[key]);
        return keys
            .map((key) => (Array.isArray(query[key]) ? this.addArrayQueryParam(query, key) : this.addQueryParam(query, key)))
            .join("&");
    }

    protected addQueryParams(rawQuery?: QueryParamsType): string {
        const queryString = this.toQueryString(rawQuery);
        return queryString ? `?${queryString}` : "";
    }

    private contentFormatters: Record<ContentType, (input: any) => any> = {
        [ContentType.Json]: (input: any) =>
            input !== null && (typeof input === "object" || typeof input === "string") ? JSON.stringify(input) : input,
        [ContentType.Text]: (input: any) => (input !== null && typeof input !== "string" ? JSON.stringify(input) : input),
        [ContentType.FormData]: (input: any) =>
            Object.keys(input || {}).reduce((formData, key) => {
                const property = input[key];
                formData.append(
                    key,
                    property instanceof Blob
                        ? property
                        : typeof property === "object" && property !== null
                            ? JSON.stringify(property)
                            : `${property}`,
                );
                return formData;
            }, new FormData()),
        [ContentType.UrlEncoded]: (input: any) => this.toQueryString(input),
    };

    protected mergeRequestParams(params1: RequestParams, params2?: RequestParams): RequestParams {
        return {
            ...this.baseApiParams,
            ...params1,
            ...(params2 || {}),
            headers: {
                ...(this.baseApiParams.headers || {}),
                ...(params1.headers || {}),
                ...((params2 && params2.headers) || {}),
            },
        };
    }

    protected createAbortSignal = (cancelToken: CancelToken): AbortSignal | undefined => {
        if (this.abortControllers.has(cancelToken)) {
            const abortController = this.abortControllers.get(cancelToken);
            if (abortController) {
                return abortController.signal;
            }
            return void 0;
        }

        const abortController = new AbortController();
        this.abortControllers.set(cancelToken, abortController);
        return abortController.signal;
    };

    public abortRequest = (cancelToken: CancelToken) => {
        const abortController = this.abortControllers.get(cancelToken);

        if (abortController) {
            abortController.abort();
            this.abortControllers.delete(cancelToken);
        }
    };

    public request = async <T = any, E = any>({
                                                  body,
                                                  secure,
                                                  path,
                                                  type,
                                                  query,
                                                  format,
                                                  baseUrl,
                                                  cancelToken,
                                                  ...params
                                              }: FullRequestParams): Promise<HttpResponse<T, E>> => {
        const secureParams =
            ((typeof secure === "boolean" ? secure : this.baseApiParams.secure) &&
                this.securityWorker &&
                (await this.securityWorker(this.securityData))) ||
            {};
        const requestParams = this.mergeRequestParams(params, secureParams);
        const queryString = query && this.toQueryString(query);
        const payloadFormatter = this.contentFormatters[type || ContentType.Json];
        const responseFormat = format || requestParams.format;

        return this.customFetch(`${baseUrl || this.baseUrl || ""}${path}${queryString ? `?${queryString}` : ""}`, {
            ...requestParams,
            headers: {
                ...(requestParams.headers || {}),
                ...(type && type !== ContentType.FormData ? {"Content-Type": type} : {}),
            },
            signal: (cancelToken ? this.createAbortSignal(cancelToken) : requestParams.signal) || null,
            body: typeof body === "undefined" || body === null ? null : payloadFormatter(body),
        }).then(async (response) => {
            const r = response as HttpResponse<T, E>;
            r.data = null as unknown as T;
            r.error = null as unknown as E;

            const data = !responseFormat
                ? r
                : await response[responseFormat]()
                    .then((data) => {
                        if (r.ok) {
                            r.data = data;
                        } else {
                            r.error = data;
                        }
                        return r;
                    })
                    .catch((e) => {
                        r.error = e;
                        return r;
                    });

            if (cancelToken) {
                this.abortControllers.delete(cancelToken);
            }

            if (!response.ok) throw data;
            return data;
        });
    };
}

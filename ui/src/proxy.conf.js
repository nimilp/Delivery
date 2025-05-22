const PROXY_CONFIG = [
  {
    "context": ['/api/**'],
    "target": 'http://localhost:8081/keralakitchen/',
    "secure": false,
    "changeOrigin": true,
    "logLevel": 'debug',
    "pathRewrite": {
      "^/api": ""
    },
    "onProxyReq": (proxyReq, req, res) => {
      console.log(`[Proxy Request] ${req.method} ${req.url} -> ${proxyReq.method} ${proxyReq.path}`);
    },
    "onProxyRes": (proxyRes, req, res) => {
      console.log(`[Proxy Response] ${req.method} ${req.url} -> ${proxyRes.statusCode} ${proxyRes.statusMessage}`);
    }
    // "changeOrigin": true
  }
]

module.exports = PROXY_CONFIG;
